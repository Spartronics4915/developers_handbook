# Spartronics Git Workflow

For introduction to git, please see section [Git Intro](../git_intro/README.md)

<!-- TOC -->

- [Spartronics Git Workflow](#spartronics-git-workflow)
  - [Overview](#overview)
    - [Resources](#resources)
  - [Workflow Steps](#workflow-steps)
  - [Top 5 Commands](#top-5-commands)

<!-- /TOC -->

## Overview
The Spartronics Programming Team uses GitHub's _fork & pull request_ workflow.
This workflow balances flexibility with productivity for the individual developers.
- Individuals have the flexibility of working on their own repos, while
  collaborating as a small team, such as pair programming or getting code
  reviews from mentors before a pull request (PR)
- Standard practice is for developers to push their local repos to their
  remote forks, ensuring code continuity and code backup
- Programming leads can monitor and review code contributions and ensure
  that the _master_ branch is always production ready

### Resources
- [GitHub Guides: Forking Projects](https://guides.github.com/activities/forking/)
- [GitHub Gist: GitHub Forking](https://gist.github.com/Chaser324/ce0505fbed06b947d962)

## Workflow Steps
![Fork & PR Workflow](../git_intro/images/repos.png)

Basic git commands and process flow is documented [here](./git_fundamentals.md#git-fork).
If you are new to git, please start with our [Git Intro](./README.md).

Start with forking the team repo on GitHub and cloning your repo on your computer.
This command is handy to stay in sync with the _upstream_ branch:
`$ git pull upstream master`.

1. Make changes on your local repo
2. Test changes on the robot
3. `git add` the changed files
4. `git commit` to package and document the changes
5. `git push origin master` to send the commits to GitHub
6. Make a pull request at your fork's GitHub page
7. Make changes as requested in the review process, and push them to GitHub
8. `git pull upstream master` after the pull request is accepted and merged

## Top 5 Commands
1. `git status`
    - Shows the current status of your git repository, including:
        - What files you've edited (shown in red until you `git add` them)
        - What you've deleted (shown in red until you `git add` them)
        - What things are ready to be committed (shown in green)
        - Whether you have any conflicts (shown in a different color)
        - Whether your code has been pushed to your fork ("Your branch is up-to-date...")
2. `git add <file1> <file2>`
    - Adds ("stages") files to the index, which is where `git commit` pulls
        changes from
    - You can just use `git add src` to add every change you've made inside the
        `src` folder.
        - Please make sure you actually intend to commit EVERYTHING you change
            inside that folder before you run this.
    - Before moving on, it is worthwhile to use `git status` to double-check the
        list of files you want to add
3. `git commit`
    - Takes the changes staged by `git add` and records them as a new commit
    - When you run this, it opens the `vi` editor by default, so you can write a
        message for your commit. See the readme for instructions on using `vi`
    - You can also use `git commit -m "your message in quotes here"` to write a
        short message directly
4. `git pull`
    - Pulls down commits from the specified remote
    - Most often used like `git pull upstream master` -- this means "pull the
        `master` branch from the `upstream` remote
    - You need (well, you should) do this both daily and before using
        `git push`, to ensure your changes don't cause conflicts
5. `git push`
    - Pushes your commits to a remote
    - Most often used like `git push origin master` -- "push the `master`
        branch to `origin`"
    - Do this frequently to make sure your changes are backed up on GitHub
