# Spartronics Git Workflow

## Glossary

`version control`: Software that tracks how and why files change over time, and allow you to go back in time to any point.

`git`: Version control software of choice, it's very common.

`repository`: Special folder which holds version-controlled files.

`github`: Website which "hosts" Git repositories for free.

`remote`: The "remote" copy of your repository, generally the place you send code when it's ready.

`commit`: A specific point in time for your repository. Also stores the reason (message) that you made the commit. Be descriptive!

`clone`: The act of making a copy of a remote, with all its history.

`push`: The act of sending commits to a remote.

`pull`: The act of fetching commits from a remote which you don't have yet, and integrating them in to your local copy of the repository.

## Guides

- All sorts of documentation, videos, cheat sheets...: [https://git-scm.com/documentation](https://git-scm.com/documentation)
- Git wiki: [http://git.wiki.kernel.org/](http://git.wiki.kernel.org/)
- It's incredibly dense, but here's the official "Git everyday" guide: [https://jk.gs/giteveryday.html](https://jk.gs/giteveryday.html) (esp. "Individual - Participant" section)
- The official Git book, _Pro Git v2_: [https://git-scm.com/book/en/v2](https://git-scm.com/book/en/v2) (it's a website, not a physical book unless you really want a copy)
- "Git for Web Designers": [http://www.webdesignerdepot.com/2009/03/intro-to-git-for-web-designers/](http://www.webdesignerdepot.com/2009/03/intro-to-git-for-web-designers/)
- "Git for Computer Scientists", if you know what a directed acyclic graph is: [http://eagain.net/articles/git-for-computer-scientists/](http://eagain.net/articles/git-for-computer-scientists/)
- "Git in the Trenches", real-world Git usage guide: [http://cbx33.github.io/gitt/](http://cbx33.github.io/gitt/)
- "Version Control by Example" chap. 8: [http://ericsink.com/vcbe/html/git_example.html](http://ericsink.com/vcbe/html/git_example.html)
- "The Git Parable", the actual theory behind Git, doesn't cover actually using it: [http://tom.preston-werner.com/2009/05/19/the-git-parable.html](http://tom.preston-werner.com/2009/05/19/the-git-parable.html)

Source: [https://jk.gs/git/bot/trigger.php](https://jk.gs/git/bot/trigger.php)

## Top 5 Commands

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

## Setting up Git

Fork the repository here: https://github.com/Spartronics4915/2017-STEAMworks/fork

Use your package manager, or install GitHub's program here: https://desktop.github.com/

Open the "Git Shell" app (or a plain shell that knows about `git`.)

Run these commands, without the dollar sign at the front, though quotes are important:

```bash
$ git config --global user.name "Your Name"
$ git config --global user.email "the email you used to sign up for github"
$ cd
$ mkdir workspace
$ cd workspace
$ git clone https://github.com/<your username>/2017-STEAMworks
$ cd 2017-STEAMworks
$ git remote add upstream https://github.com/Spartronics4915/2017-STEAMworks
```

Now that everything is set up, you can just use this command to get back there
in the future. You'll have to do this every time you open the shell.

```bash
$ cd ~/workspace/2017-STEAMworks
```

Now use the rest of the git commands to save your work.

## Rest of the workflow

Before starting work on something: `$ git pull upstream master`

1. Make changes
2. Test changes
3. `git add` the changes
4. `git commit` the changes
5. `git push origin master` the commits
6. Make a pull request at your fork's web page
7. `git pull upstream master` once pull request is accepted
