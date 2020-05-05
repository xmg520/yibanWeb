#!/usr/bin/env python
#-*-coding:utf-8-*- 
__author__ = 'Mzx'

import requests,pymysql,time,json

# 数据库连接信息
conn = pymysql.connect(host='118.31.22.111',user='1234',password='1234',database='yiban',port=9527)

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


    weixin_context = ""

    with open('yiban.log','a',encoding='utf-8',newline='') as fp:

        fp.write("时间："+time.strftime("%Y-%m-%d %H:%M:%S",time.localtime())+"\n")
        fp.write("已完成人员：\n")
        weixin_context += ("时间：" + time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()) + "\n"+"已完成人员：\n")
        for name in nice_names:
            fp.write(name+"\n")
            weixin_context += (name+"\n")
        fp.write("未及时完成人员：\n")
        weixin_context += ("未及时完成人员：\n")
        for name in forget_names:
            fp.write(name+"\n")
            weixin_context += (name+"\n")
        weixin_context += ("*"*10)
        fp.write("*"*10+"\n\n")
    # print(weixin_context)

    # 微信公众号发送信息
    url_token = 'https://api.weixin.qq.com/cgi-bin/token?'
    res = requests.get(url=url_token, params={
        "grant_type": 'client_credential',
        'appid': "wx352070fe7a5943c8",  # 这里填写上面获取到的appID
        'secret': "9682cfae67d0bb35c1d282a614b2a195",  # 这里填写上面获取到的appsecret
    }).json()
    token = res.get('access_token')
    # print(res)

    url_msg = 'https://api.weixin.qq.com/cgi-bin/message/custom/send?'
    body = {
        "touser": "omhBwwcpobS26WuH9Eb3SDHiBGZo",  # 这里必须是关注公众号测试账号后的用户id
        "msgtype": "text",
        "text": {
            "content": weixin_context
        }
    }

    res = requests.post(url=url_msg, params={
        'access_token': token  # 这里是我们上面获取到的token
    }, data=json.dumps(body, ensure_ascii=False).encode('utf-8'))



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

    print(response.text)
    if response.text == "Applied today":
        nice_names.append(name)
    else:
        forget_names.append(name)


# 主函数模块
if __name__ == "__main__":
    py_user()
    create_log()
