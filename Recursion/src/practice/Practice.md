### 10，对于三个盘子，7.7节给出的两个solveTower算法各有多少次递归调用。
答：

算法1：solveTower(numberOfDisks, startPole, tempPole, endPole)
    if(numberOfDisks == 1)
        将盘子从startPole 移到 endPole
    else
    {
        solveTower(numberOfDisks - 1, startPole, endPole, tempPole)
        将盘子从startPole 移到 endPole
        solveTower(numberOfDisks - 1, tempPole, startPole, endPole)
    }
三个盘子会有

    2 + 2 = 4次递归调用

算法2：solveTower(numberOfDisks, startPole, tempPole, endPole)
    if(numberOfDisks > 0)
    {
        solveTower(numberOfDisks - 1, startPole, endPole, tempPole)
        将盘子从startPole 移到 endPole
        solveTower(numberOfDisks - 1, tempPole, startPole, endPole)
    }
三个盘子会有
    2*（3-1） = 6 次递归


