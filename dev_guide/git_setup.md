# Git Setup

## Installing Git
If you haven't already, download and install Git from [here.](https://git-scm.com/)
On macOS and most Linux systems, Git comes preinstalled by default. Check with
`git --version` in a terminal.

In Windows, it's strongly suggested to use Git Bash as your terminal.

## Configuring Git

It's good if everyone knows who you are when working in groups.
Git's `user.name` and `user.email` options help us tell who you are when `commit`ing
any code.

`git config --global user.name "FirstName LastName"` will set your name.
The `--global` tag sets it for all Git projects, not just one repository.

`git config --global user.email "your@email.com"` sets an email associated with
your commits. **It is important to use the email you signed up with GitHub with.**

Finally, check that you have entered in the correct username and email with
`git config --list`.