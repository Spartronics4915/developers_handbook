# Spartronics Git Workflow

For introduction to git, please see section [Git Intro](../git_intro/README.md)

<!-- TOC -->

- [Spartronics Git Workflow](#spartronics-git-workflow)
- [Overview](#overview)
    - [Resources](#resources)
- [Workflow Steps](#workflow-steps)
- [Top 5 Commands](#top-5-commands)

<!-- /TOC -->

# Overview
Spartronics Programming Team uses the GitHub's fork & pull request workflow.
This workflow balances flexibility with productivity for the individual developers.
* Individuals have the flexibility of working on their own repos, while
  collaborating as a small team, such as pair programming or getting code
  reviews from mentors before a PR
* Standard practice is to push local repo to remote forks, ensuring code
  continuity and code backup
* Programming leads can monitor and review code contributions and ensuring
  master is always production ready

## Resources
* [GitHub Guides: Forking Projects](https://guides.github.com/activities/forking/)
* [GitHub Gist: GitHub Forking](https://gist.github.com/Chaser324/ce0505fbed06b947d962)

# Workflow Steps
![Fork & PR Workflow](../git_intro/images/repos.png)

Basic git commands and process is documented [here](../git_intro/git_fundamentals.md#git-fork). If you are new to git, please start w/ our [Git Intro](../git_intro/README.md).

Start with pulling the initial repo and establishing your local repo. This command is handy to stay in sync w/ upstream: `$ git pull upstream master`.

1. Make changes on your local repo
2. Test changes on the robot
3. `git add` the changes
4. `git commit` the changes
5. `git push origin master` the commits
6. Make a pull request at your fork's web page
7. `git pull upstream master` once pull request is accepted

# Top 5 Commands
1. `git status`
    - Shows the current status of your git repository, including:
        - What files you've edited (shown in red until you `git add` them)
        - What you've deleted (shown in red until you `git add` them)
        - What things are ready to be committed (shown in green)
        - Whether you have any conflicts (shown in a different color)
        - Whether your code has been pushed to your fork ("Your branch is up-to-date...")
1. `git add <file1> <file2>`
    - Adds ("stages") a file to the index, which is where `git commit` pulls changes from
    - You can just use `git add src` to add every change you've made inside the `src` folder.
        - Please make sure you actually intend to commit EVERYTHING you change inside that folder before you run this.
1. `git commit`
    - Takes the changes staged by `git add` and records them as a new commit
    - When you run this, it opens the `vi` editor by default, so you can write a message for your commit. See the readme for instructions on using `vi`
    - You can also use `git commit -m "your message in quotes here"` to write the message directly
1. `git pull`
    - Pulls down commits from the specified remote
    - Most often used like `git pull upstream master` -- this means "pull the `master` branch from the `upstream` remote
    - You need (well, you should) do this both daily and before using `git push`, to ensure your changes don't cause conflicts
1. `git push`
    - Pushes your commits to a remote
    - Most often used like `git push origin master` -- "push the `master` branch to `origin`"
    - Do this after you make a couple commits