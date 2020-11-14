# Git Tutorial
The goal of this tutorial is to give students hands-on experience in dealing
with three of the most common aspects of Git - writing, staging and
committing code, resolving merge conflicts, and opening pull requests.

<!-- TOC -->

- [Git Tutorial](#git-tutorial)
  - [Staging and Committing Code](#staging-and-committing-code)
  - [Dealing with Merge Conflicts](#dealing-with-merge-conflicts)
  - [Opening Pull Requests](#opening-pull-requests)

<!-- /TOC -->

## Staging and Committing Code

1. [Install Git.](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals)
2. [Configure your username and email.](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#important-set-up-for-the-new-git-user)
3. Create a [fork](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#git-fork) of our [git-learning repository](https://github.com/Spartronics4915/git-learning) to your account on GitHub.
4. Open up a Git-enabled terminal, and [clone](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#git-clone) the fork you've created to your computer.
5. [Change directory](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_faq#common-bash-shell) into git-learning.
6. [Edit] the `HelloWorld.java` file, and replace `"Hello, Conflicts!"` with another phrase of your choice.
7. [Stage and commit](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#adding-files) `HelloWorld.java`.

## Dealing with Merge Conflicts
Once everyone has changed code and committed, one of the programming leads will
push a commit that will cause a [merge conflict](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#merge-conflicts)
to the Spartronics repository. Merge conflicts are incredibly common when
working collaboratively, and learning how to resolve them is an important
skill.

1. Make sure you're in the git-learning directory, and [pull from upstream](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#git-pull-vs-git-fetch-and-and-git-merge) (`git pull upstream master`).
2. You should be alerted of [merge conflicts](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#merge-conflicts) - edit the offending file, and resolve them manually.
3. Stage and commit your merge-resolved `HelloWorld.java` file.

## Opening Pull Requests
Now that you've dealt with your merge conflicts, the next step is to get your
changes into upstream - the Spartronics organization's copy of git-learning.
In a usual season, your code will also be reviewed by the subteam leads and
mentors you're working with, and implement feedback accordingly.

1. Make sure you're in the git-learning directory, and [push your commits to your fork](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#git-push).
2. Navigate to the Spartronics4915 git-learning repository, and [open a pull request](https://spartronics4915.gitbook.io/developer-handbook/git_introduction/git_fundamentals#github-pull-request) from your fork.
3. Request review from one of the programming leads from the right sidebar.
4. Submit your pull request, and you're done!
