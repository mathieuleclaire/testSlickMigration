## Generate the h2 base with one Users Table:

1. Comment all the references to the field ```toto``` in the Users file
2. Set the h2 file location (/tmp/h2 by default)
3. Uncomment the Create section in the TestMigration file
4. Comment the Update section in the TestMigration file
5. Launch run 0

## Do the migration

1. Go back to the initial code
2. Launch run 1

## Issue
Looking to the h2 table demonstrates that no ```TOTO``` column has not been added
