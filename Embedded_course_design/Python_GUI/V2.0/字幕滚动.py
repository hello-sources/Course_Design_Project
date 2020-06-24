import time
 
while True:
    print('钻石永久远，一颗永流传', end=' ')
    for i in range(10):
        print('·', end='', flush=True) #去掉flush参数效果也一样
        time.sleep(0.3)
    print('\r',end='')