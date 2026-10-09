# Data Store Management

A **Java Swing desktop application** for running a small beverage distribution business ("Rrushi"). It tracks the drinks catalogue and the retail stores they're delivered to, issues stock to stores with an assigned driver and truck, records returns and payments, and shows the results in statistics tables. All data is stored in **MySQL**.

## Features

- **User accounts**: sign up, log in, and recover a password with a security question and answer
- **Drinks catalogue**: add drinks with ID, name, grade (`Grada`), export flag, price and quantity
- **Stores**: register stores with city, location, country, driver (`Shofer`) and truck (`Kamiona`)
- **Issue**: look up a drink and a store by ID and record a delivery with its date of issue
- **Return / payment**: settle an issued delivery, which moves it to the `return` table with a return date
- **Statistics**: two live tables, *Issued Drinks* and *Paid Drinks*, loaded straight from the database
- Splash/loading screen, plus an About dialog

## Tech stack

| | |
| --- | --- |
| Language | Java 8 |
| UI | Swing, designed with the NetBeans GUI Builder (`.form` files) |
| Database | MySQL via JDBC (`mysql-connector-java` 8.0.19) |
| Tables in UI | rs2xml (`DbUtils.resultSetToTableModel`) |
| Build | Apache Ant (NetBeans project) |

## Project structure

```
src/compap/
  Compap.java           # shared JDBC connection helper
  Loading.java          # splash screen
  login.java            # login (configured main class)
  SignUp.java           # account creation
  forgotpassword.java   # security-question password recovery
  Home.java             # main menu
  Drinks.java           # drinks catalogue
  Stores.java           # store registration
  Issue.java            # issue drinks to a store
  Return.java           # returns / payments
  Statistics.java       # issued vs. paid drinks
  About.java
build.xml, nbproject/   # Ant / NetBeans build configuration
```

## Running locally

1. Install **JDK 8+**, **MySQL** and **NetBeans** (or Apache Ant).
2. Create a MySQL database named `db22` with the tables `users`, `drinks`, `stores`, `issue` and `return`. You can read the column names off the SQL statements in `src/compap/*.java`.
3. Add `mysql-connector-java-8.0.19.jar` and `rs2xml.jar` to the project libraries. `nbproject/project.properties` points to local Windows paths, so update those paths for your machine.
4. Set your database user and password in `src/compap/Compap.java`.
5. Run the project. The configured main class is `compap.login`.

```bash
ant run
```

## Known limitations

This was a 2021 university project and it shows its age:

- Database credentials are hard-coded in `Compap.java`, not read from configuration
- Passwords are stored in plain text, and one lookup query concatenates user input into SQL
- No schema migration script is included

A production version would hash passwords (e.g. bcrypt), use parameterized queries everywhere, and load configuration from the environment.

## License

[MIT](LICENSE)

---

Built by [Rexhino Kovaci](https://github.com/rexhinokovaci) — DevOps & AI engineer in Tirana, Albania. Need an app built? [Get in touch](mailto:kovacirexhino@gmail.com).
