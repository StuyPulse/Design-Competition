# Design Competition Repository

## Making a Branch

In order to make a new branch, please type this into your terminal:

```
$ git checkout -b groupName/branchName
```

An example branch name would be "coolBeans/drivetrain".

Please do all of your programming on your team's branches.

An example branch has been made called `SamsExampleBranch`

## Building your project

In order to build your project, you must type into your git terminal:

```
$ ./gradlew build
```

## Merging a Branch into Master

In order to merge a branch into master, please merge master into your branch first:

```
$ git merge master
```

After fixing any merge conflicts, make a pull request and let Renee or Sam know. They will go over your code and either request changes or approve it.

## Group 3 - Subsystems
- Drivetrain
  - 6 CANSparkMax's
- Intake
  - 2 TalonSRX's
  - 2 double solenoids
- "Chute"
- Shooter
  - 6 CANSparkMax's
  - 1 Sensor(DigitalInput)
- Climber
- Control Panel
