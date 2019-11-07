# FAQ: git, vi, bash shell

Anything that relates to git or git related tools such as vi, or unix commands.

* [Frequently Asked Questions](git_faq.md#frequently-asked-questions)
  * [Common bash shell](git_faq.md#common-bash-shell)
  * [Common vi commands](git_faq.md#common-vi-commands)
  * [Common Git commands](git_faq.md#common-git-commands)
    * [How do I revert previous commit?](git_faq.md#how-do-i-revert-previous-commit)
    * [What is "non-fast-forward"?](git_faq.md#what-is-%22non-fast-forward%22)

## Common bash shell

```bash
# print working directory$ pwd# list contents of current directory$ ls# list contents of <dir>$ ls <dir># list all/hidden files$ ls -a# take me to my home directory$ cd# change directory to <dir name>$ cd <dir># change to directory above$ cd ..# type file to your screen$ cat <filename># make directory$ mkdir <dir_name># delete a file$ rm <filename># recursively delete a directory -- BE VERY CAREFUL WITH THIS COMMAND!!$ rm -rf <directory-name># move a file from current directory to another directory location$ mv <filename> <directory-location># rename a file in current directory -- applies to filename or directory name$ mv <oldname> <newname># move & rename a file from current directory to directory above$ mv <filename> ../<new-filename>
```

## Common vi commands

Git's default fallback editor is `vi`, a terminal text editor, similar to nano, but with a higher learning curve and more functionality.

Refer to various reference cards, such as [this one](https://www.ks.uiuc.edu/Training/Tutorials/Reference/virefcard.pdf).

It's important to know that vi has two modes: insertion and command. When you first start vi, editor is in command mode. "i" puts the editor in insertation mode, where you can type without triggering commands -- ESC returns the editor into command mode.

Common commands \(in command mode\):

```bash
# quit w/o saving -- <shift><:>:q!# save & quit:wq# change to insert modei# delete worddw
```

## Common Git commands

We gave out a "Git Cheatsheet" at the beginning of the year that is very helpful. An online version can be found [here.](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf)

```bash
# sets the name attached to commits - this should be your full namegit config --global user.name "name"# sets the email attached to commits - should be the email used for GitHubgit config --global user.email "email"# makes a new local repository with the specified namegit init <projectname># downloads a repository in the current directorygit clone <url>.git# stages all modified files for commitgit add .# commits all staged changes with a commit messagegit commit -m "Commit message"# pushes all commited changes to the origin repositorygit push origin master# pulls all changes from the latest version of the codegit pull upstream master# fetches the latest commits without merging themgit fetch <repository> <branch># gets rid of ALL your changes and resets the repository to upstream - use with EXTREME CAUTIONgit reset --hard upstream/master
```

### How do I revert previous commit?

Sometimes you mess up, and don't realize it until after committing your changes.

Git makes it easy to _revert_ your changes with use of the `git reset` command. Git reset lets you revert to a previous commit hash, which you have to find first with `git log`.

Read more about git reset in [git fundamentals.](https://github.com/Spartronics4915/developers_handbook/tree/30d0a3bea4d6340fca6351d388d8199a004316e2/git_introduction/git_fundamentals/README.md#git-init)

### What is "non-fast-forward"?

When your local repo is behind the repo you are pushing to you will see an error non-fast-forward updates were rejected. That means you need to retrieve the changes before you can push your changes. Read more about [git pull vs git fetch and git merge.](https://github.com/Spartronics4915/developers_handbook/tree/30d0a3bea4d6340fca6351d388d8199a004316e2/git_introduction/git_fundamentals/README.md)

