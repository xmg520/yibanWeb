#!/usr/bin/env python
#-*-coding:utf-8-*- 
__author__ = 'Mzx'

import requests,pymysql,time,json

# 数据库连接信息
conn = pymysql.connect(host='118.31.22.111',user='qweqwe',password='root',database='yiban',port=3306)

cursor = conn.cursor()

session = requests.session()

sql = """
    select account,passwd,city,name from member
"""

# 提交每天未签到名单
sql1 = """
    insert into noupload(id,time,names) values (null,%s,%s)
"""

# 今日忘记上传数据成员
forget_names = []

# 今日成功直接上传人员
nice_names = []

# 准备头部文件
headers = {'Host': 'yinqing.hnevc.com',
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
        'Origin': 'http://yiqing.hnevc.com',
        'Referer': 'http://yiqing.hnevc.com/',
        'X-Requested-With': 'XMLHttpRequest',
        'Accept-Encoding': 'gzip, deflate',
        'Accept-Language': 'zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,zh-TW;q=0.6',
        'User-Agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36'
        }

# 生成日志文件
def create_log():
    if len(forget_names) > 0:
        names_text = ",".join(str(i) for i in forget_names)
        lotime = time.strftime("%m-%d")
        cursor.execute(sql1,(lotime,names_text))
        conn.commit()
        conn.close()


# 数据库查询模块
def py_user():
    cursor.execute(sql)
    py_data = cursor.fetchall()
    for i in  py_data:
        print(time.strftime("%Y-%m-%d %H:%M:%S",time.localtime()))
        print("执行操作：操作对象 =>"+i[3]+",学号:"+i[0])
        login_yiban(i[0],i[1],i[2],i[3])


# 模拟登陆模块
def login_yiban(account,passwd,city,name):
    login_url = "http://yiqing.hnevc.com/login/Login.htm"


    data = {
        "username": int(account),
        "password": str(passwd),
        "verification": '',
    }

    session.post(url=login_url,data=data,headers=headers)
    up_mes(city,name)

# 提交信息模块
def up_mes(city,name):
    up_url = "http://yiqing.hnevc.com/syt/zzapply/operation.htm"


    data = {
        'data':'{"xmqkb":{"id":"000000007044850701704491248b007c"},"c1":"'+city+'","c2":"正常","c3":"36-36.9°C","c4":"否","c6":"否","c7":"否","c8":"否","c9":"否","c10":"否","c12":"良好","c13":"否","c14":"否","c15":"否","type":"YQSJSB"}',
        'msgUrl':'syt/zzapply/list.htm?type=YQSJSB&xmid=000000007044850701704491248b007c',
        'uploadFileStr':'{}'
    }

    response = session.post(url=up_url,data=data,headers=headers)

    if response.text == "Applied today":
        nice_names.append(name)
    else:
        forget_names.append(name)


# 主函数模块
if __name__ == "__main__":
    py_user()
    create_log()
