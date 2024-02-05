# MeWantFood: AYE LMAO ISS THE PLAYGROUND BRANCH

When you want to merge dev to your own branch (which you should do before pushing your branch up), here are your steps:


1. git checkout dev
2. git pull origin dev
3. git checkout [featurebranchname]
4. git merge dev (resolve any merge conflicts here)
5. git push origin [featurebranchname]
