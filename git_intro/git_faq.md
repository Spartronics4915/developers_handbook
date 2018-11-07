# FAQ

Anything that relates to git or git related tools such as vi, or unix commands.

<!-- TOC -->

- [FAQ](#faq)
- [Common bash shell](#common-bash-shell)
- [Common vi commands](#common-vi-commands)
- [Common git questions](#common-git-questions)
    - [How do I revert previous commit?](#how-do-i-revert-previous-commit)
    - [What is "non-fast-forward"?](#what-is-non-fast-forward)

<!-- /TOC -->

# Common bash shell
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

# Common vi commands
Refer to various reference cards, such as [this one](https://www.ks.uiuc.edu/Training/Tutorials/Reference/virefcard.pdf).

Important to remember vi has two modes: insertion and command. When you first start vi, editor is in command mode -- ESC returns the editor into command mode. Common commands:

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

# Common git questions
## How do I revert previous commit?

## What is "non-fast-forward"?

When your local repo is behind the repo you are pushing to you will see an error
non-fast-forward updates were rejected. That means you need to retrieve the
changes before you can push your changes. Read more about [git pull vs git fetch
&& git merge](./git_fundamentals.md#(#git-pull-vs-git-fetch-&&-git-merge)