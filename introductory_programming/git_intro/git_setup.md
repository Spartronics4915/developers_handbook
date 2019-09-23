# Git Setup

## Installing Git

On macOS and Linux, `git` should already be installed. You can check if it's already installed by running
`git --version` in a terminal.


If you're running Windows, you need to download and install Git from [here](https://git-scm.com/download/win).<br>
It's suggested to use Visual Studio Code as Git's default editor, unless you feel comfortable using one of the other options.

## Configuring Git

Since we work collaboratively on code, everyone needs to know who you are. Git's `user.name` and `user.email` options tell us that when `commit`ing
any code.

`git config --global user.name "FirstName LastName"` will set your name. The `--global` tag sets it for all Git projects, not just one repository.

`git config --global user.email "your@email.com"` sets an email associated with
your commits. **It is important to use the email you signed up with GitHub with.**

Finally, check that you have entered in the correct username and email with
`git config --list`.
