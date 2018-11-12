# More Git!
It is important to understand that every git repository is completely standalone
and functional by itself, without dependency on other repositories. Main
commands we covered in the [git fundamentals](./git_fundamentals.md) section
(pull, push, fetch) enables transferring/sharing different versions of the code
to other repos.

In this section, we will dive deeper into git structure and other git commands and tools to help improve productivity.
<!-- TOC -->

- [More Git!](#more-git)
- [Resources & References](#resources--references)
- [Git Structure](#git-structure)
    - [Intro to git internals](#intro-to-git-internals)
    - [Branches and Tags](#branches-and-tags)
    - [Git HEAD](#git-head)
    - [Tracking and merging branches](#tracking-and-merging-branches)
        - [git rebase & git squash](#git-rebase--git-squash)
    - [Reverting changes](#reverting-changes)
- [Git Commands & Helful Tools](#git-commands--helful-tools)
    - [Git bash completion](#git-bash-completion)
    - [More on gitconfig](#more-on-gitconfig)
    - [git diff](#git-diff)
    - [git stash](#git-stash)
    - [git references or refs](#git-references-or-refs)
    - [remove or move a file: git rm && git mv](#remove-or-move-a-file-git-rm--git-mv)

<!-- /TOC -->

# Resources & References
There are great resources on git.

* [Commit Often, Perfect Later, Publish Once: Git Best Practices](https://sethrobertson.github.io/GitBestPractices/)
* [Pro Git Book](https://git-scm.com/book/en/v2)
* [Introduction to distributed version control w/ git](https://cleanercode.com/introduction-to-git-talk/introduction-to-git.pdf)

# Git Structure
## Intro to git internals
Git repo is basically a hidden directory (.git) at the top level of your repo.
It holds everything that is needed to track the needed changes. If you want to
backup your repo, this is the only directory you will need.

```sh
$ git init
Initialized empty Git repository in /Users/binnur/tmp/git/a_project/.git/
$ ls -F1 .git
HEAD
config
description
hooks/
info/
objects/
refs/
```
For more background on the git internals, checkout [git book]
(https://git-scm.com/book/en/v2/Git-Internals-Plumbing-and-Porcelain).

HEAD is a symbolic reference to the branch you are on. Git is a tree structure
where each commit creates a new node in that tree, and git commands help
navigate that tree.

Git is immutable by design -- every new change creates a new set of nodes, which
makes git *almost* indestructible.

```sh
# graphical history tool
$ gitk --all
```

## Branches and Tags
A branch is a pointer to a specific commit. Switching branches walks the tree to
derive the history of the repo. _git tag_ is similar to _git branch_, however
it operates like a bookmark to a specific point in time.

```sh
# create a new branch
$ git branch <branch-name>
# switch to the new branch
$ git checkout <branch-name>
# create and checkout the branch simultaneously
$ git checkout -b <branch-name>
# checkout master branch
$ git checkout master
# list branches that are tracked
$ git branch
# list all branches, including remotes
$ git branch -a
# pull all branches and tags from remotes
$ git fetch --all
# pull branches from a specific remote
$ git fetch origin
```

In git, branches basically another node in the tree -- this makes them
lightweight. Many teams use feature-driven branching to aid their workflow.

_git tag_ is useful for marking special releases. A tag can be lightweight, just a pointer, or annotated w/ tagger name, description, date, etc.

```sh
# list existing tags
$ git tag
# search for a specific tag
$ git tag -l "v1.8*"
# create a tag w/ an annotated message
$ git tag -a v1.0 -m "Release ready for 1st match"
# create a tag w/ annotation and prompt editor for message
$ git tag -a v1.0 -m
# show details on the tag
$ git show v1.0
# lightweight tag -- only stores commit info
$ git tag v1.1
```

*Important* by default, _git push_ does not push the tags or the branches to the
remotes. You need to explicitly share them.

```sh
# push git tags
$ git push origin <tag-name>
# push all existing tags
$ git push origin --tags
# delete a tag --> this doesn't remove the tag from remotes
$ git tag -d <tag-name>
# remote a tag from the remote
$ git push origin :refs/tags/<tag-name>
# you can checkout a tag, though it creates a DETACHED HEAD state
$ git checkout <tag-name>
```

## Git HEAD

By now you may be wondering what "HEAD" is and why it's possible
to become detached. HEAD is git's way of referring to your current view
of the repository, and corresponds to a single commit hash. Generally,
this means HEAD matches the lastest commit on your current branch.
A detached HEAD state means that you no longer are viewing the latest
commit on a branch, and are instead veiwing an intermediate commit.
As such, making additional commits will not directly contribute to
the history of one of your branches, and will require more finesse to
integrate into your project.

This does not mean that the detached HEAD state is useless. Far from it.
It is a great way to rewind history and examine previously working bits
of code, in order to find out where it all went wrong.

```sh
# Checkout a previously working commit/tag
$ git checkout <commit-sha-or-tag-name>
# From detached HEAD state, your local repository now matches the commit
# You can compile and test code
# Commits you make will be off of the detached HEAD state and wont be kept by default
$ git add .
$ git commit -m "A commit on a detached HEAD"
# Create a new branch from the detached HEAD state in order to keep commits
$ git checkout -b <new-branch-name>
# The commits you made before making the branch are still tracked
# HEAD now points to the end of the new branch (not detached)
# Merge your changes back into master.
$ git checkout master
$ git merge <new-branch-name>
```

Git checkout performs double duty. When used on a branch, tag, or commit
hash it will move your HEAD to the corresponding commit, changing the view
of your repository. If used on a file, it will modify the file to the version
it was in in the appropriate commit (which defaults to HEAD). The changes
will happen in your current branch/state, meaning it will then be possible to
commit the old version of the file to your current branch.

```sh
# Checkout the version of your file as it was in HEAD 
# WARNING: discards all unstaged, uncommitted changes
$ git checkout <file>
# Checkout the version of your file as it was in a tag/commit
$ git checkout <commit-sha-or-tag-name> <file>
```

For convenience, HEAD^ refers to the commit before HEAD, and HEAD^^ to the commit
before that.

## Tracking and merging branches
By default, git branches do not know about each other. Tracking creates linkages
between the two repos, making it easier to stay in sync between two repos as git
will inform you if your branch is ahead or behind the tracked branch.

```sh
# track via --track option
$ git checkout --track origin/<branch-name>
# set the tracking on your HEAD branch
$ git branch -u origin/<branch-name>
```

Branches explicitly need to be pushed to remotes. Similarly, explicitly deleted. Note, you can also use GitHub interface for deleting branches on remotes.

```sh
# push a new branch
$ git push -u origin dev
# delete a remote branch
$ git push origin --delete <branch-name>
```

While _git branch_ creates a fork in the road, _git merge_ allows the forked
history to be integrated again. A typical example is to merge a feature branch
to master. Process overview:
* checkout the branch to be updated
* specify the merge from a target branch
* optional: delete the target branch

```sh
# checkout master branch or verify you are on the receiving branch 
$ git checkout master
$ git status
# merge from another branch, such as a feature branch
$ git merge <feature-branch>
# optionally delete the feature branch
$ git branch -d <feature-branch>
```

If a conflict occurs during merge that git needs you to decide, git will edit
the content of the affected files with visual indicators: <<<<<<<, =======, and
\>>>>>>>. You can search for these indicators to resolve the conflicts.

### git rebase & git squash
_git rebase_ is basically merging w/ history -- git takes commits in one branch
and attempts to "replay" the differences onto the other branch.

```sh
# applying feature branch to master
$ git checkout <feature-branch>
$ git rebase master
```

_git squash_ condenses the commits, think G-rated version of sausage making,
creating a concise and readable history. Interactive rebasing allows selecting
and squashing commits.

```sh
# interactive shell for rebase
$ git rebase -i <branch>
```

## Reverting changes
There are different ways to undo prior changes and commits.
* _revert_ takes a specified commit and creates a new commit which inverses the
  specified commit -- safe operation as creates a new commit
* _reset_ takes a specified commit and resets to match the state of the repo at
  that specified commit -- can cause conflicts is history is changed

  Some common operations are below.

```sh
# discard changes in working directory
$ git checkout -- <filename>
# discard staged files
$ git reset HEAD
```

# Git Commands & Helful Tools
## Git bash completion
If you are using bash shell, there is a nice auto-complete feature you can enable for git.

Follow the instructions for setting it up: [git-completion.bash](https://github.com/git/git/blob/master/contrib/completion/git-completion.bash).

## More on gitconfig
_gitconfig_ has handy tools/options from customizing git colors to setting
aliases. More on
[_gitconfig_](http://michaelwales.com/articles/make-gitconfig-work-for-you/).

```sh
# enable git colors
$ git config --global color.ui auto
$ git config --global alias.co checkout
$ git config --global alias.st status
```

## git diff
Git can show you a list of differences between two commits, or a list of
differences between a given commit and the current state using the command _git
diff_.

```sh
# diff between what you changed and haven't staged
$ git diff <filename>
# diff between current branch and another branch
$ git diff <branch-name>
```

## git stash
There are times when you are not ready to commit, but you need to change
branches -- _git stash_ is to your rescue. It stashes your changes to be returned to at a later time.

```sh
# stash your changes
$ git stash
# restore your prior stash -- git default to most recent stash
$ git stash apply
# see a list of your stashes
$ git stash list
# remove a stash
$ git stash drop
```

## git references or refs
Instead of referencing git contents via sha-1 value, such as `git log 1a410e`,
you can create named references to that value.

`git branch <branchname>` creates refs using `git update-ref` command to add the
sha value with the given branch.

```sh
# create and checkout branch
$ git checkout -b a_branch
# print out content of HEAD
$ cat .git/HEAD
ref: refs/heads/a_branch
```

## remove or move a file: git rm && git mv
There will be times when you need to remove a file from your git repo, use _git rm_ or remove command. And, when you need to move or rename a file, use _git mv_ or move command.

```sh
# remove unwanted file from the repo
$ git rm <filename>
# move a file/directory
$ git mv <oldname> <newname>
```
