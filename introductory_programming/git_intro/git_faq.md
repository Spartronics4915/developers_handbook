# FAQ

Anything that relates to git or git related tools such as vi, or unix commands.

<!-- TOC -->

- [FAQ](#faq)
  - [Common bash shell](#common-bash-shell)
  - [Common vi commands](#common-vi-commands)
  - [Common Git commands](#common-git-commands)
    - [How do I revert previous commit?](#how-do-i-revert-previous-commit)
    - [What is "non-fast-forward"?](#what-is-%22non-fast-forward%22)

<!-- /TOC -->

## Common bash shell

``` sh
# print working directory
$ pwd

# list contents of current directory
$ ls
# list contents of <dir>
$ ls <dir>
# list all/hidden files
$ ls -a

# take me to my home directory
$ cd
# change directory to <dir name>
$ cd <dir>
# change to directory above
$ cd ..

# type file to your screen
$ cat <filename>

# make directory
$ mkdir <dir_name>

# delete a file
$ rm <filename>

# recursively delete a directory -- BE VERY CAREFUL WITH THIS COMMAND!!
$ rm -rf <directory-name>

# move a file from current directory to another directory location
$ mv <filename> <directory-location>
# rename a file in current directory -- applies to filename or directory name
$ mv <oldname> <newname>
# move & rename a file from current directory to directory above
$ mv <filename> ../<new-filename>
```

## Common vi commands
Refer to various reference cards, such as [this one](https://www.ks.uiuc.edu/Training/Tutorials/Reference/virefcard.pdf).

Important to remember vi has two modes: insertion and command. When you first
start vi, editor is in command mode -- ESC returns the editor into command mode.
Common commands:

```sh
# quit w/o saving -- <shift><:>
:q!
# save & quit
:wq
# insert before cursor
i
# delete word
dw
```

## Common Git commands
We gave out a "Git Cheatsheet" at the beginning of the year that is very helpful.
An online version can be found [here.](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf)

``` bash
# sets the name attached to commits - this should be your full name
git config --global user.name "name"

# sets the email attached to commits - should be the email used for GitHub
git config --global user.email "email"

# makes a new local repository with the specified name
git init <projectname>

# downloads a repository in the current directory
git clone <url>.git

# stages all modified files for commit
git add .

# commits all staged changes with a commit message
git commit -m "Commit message"

# pushes all commited changes to the origin repository
git push origin master

# pulls all changes from the latest version of the code
git pull upstream master

# fetches the latest commits without merging them
git fetch <repository> <branch>

# gets rid of ALL your changes and resets the repository to upstream - use with EXTREME CAUTION
git reset --hard upstream/master
```

### How do I revert previous commit?

### What is "non-fast-forward"?

When your local repo is behind the repo you are pushing to you will see an error
non-fast-forward updates were rejected. That means you need to retrieve the
changes before you can push your changes. Read more about
[git pull vs git fetch and git merge.](./git_fundamentals)