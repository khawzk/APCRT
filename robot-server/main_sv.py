import socket
import re
import os
import threading
import urllib.parse
import json
import base64

import socket
from os import curdir, sep

from http.server import HTTPServer,CGIHTTPRequestHandler

import json
from gpiozero import Motor
import time
import pso
# import cv2
#import curses
import base64
import io
from PIL import Image
import optimizationalgorithm


# flmotor = Motor(forward=16, backward=20, enable=21)
# frmotor = Motor(forward=13, backward=19, enable=26)
# blmotor = Motor(forward=5, backward=6, enable=12)
# brmotor = Motor(forward=17, backward=27, enable=22)

# 图片转换成base64
def image_to_base64(path):
    with open(path, 'rb') as img:
        # 使用base64进行编码
        b64encode = base64.b64encode(img.read())
        s = b64encode.decode()
        b64_encode = 'data:image/jpeg;base64,%s' % s
        # 返回base64编码字符串
        return b64_encode

def left():
    print('Left ...')
    # flmotor.backward()
    # frmotor.forward()
    # blmotor.backward()
    # brmotor.forward()

def right():
    print('Right ...')
    # flmotor.forward()
    # frmotor.backward()
    # blmotor.forward()
    # brmotor.backward()

def forward():
    print('Forwarding ...')
    # flmotor.forward()
    # frmotor.forward()
    # blmotor.forward()
    # brmotor.forward()

def reverse():
    print('backward ...')
    # flmotor.backward()
    # frmotor.backward()
    # blmotor.backward()
    # brmotor.backward()

def stop():
    print('Stopping ...')
    # flmotor.stop()
    # frmotor.stop()
    # blmotor.stop()
    # brmotor.stop()

def timestop():
    print('Stopping time 1 s ...')
    stop()
    time.sleep(1)

def camera():
    print('camera ...')
    # cap = cv2.VideoCapture(0)
    # while (cap.isOpened()):
    #     retval, frame = cap.read()
    #     cv2.imshow('Live', frame)
    #     if cv2.waitKey(5) >= 0:
    #         break

def right_90():
    print('Right 90 ...')
    right()
    time.sleep(1)
    timestop()

def left_90():
    print('left 90 ...')
    left()
    time.sleep(1)
    timestop()
#画正方形
def square():
    print('square ...')
    forward()
    time.sleep(1)
    timestop()
    left()
    time.sleep(1.4)
    timestop()
    forward()
    time.sleep(1)
    timestop()
    left()
    time.sleep(1.4)
    timestop()
    forward()
    time.sleep(1)
    timestop()
    left()
    time.sleep(1.4)
    timestop()
    forward()
    time.sleep(1)
    stop()


def  timerun(time):
    print('timerun ...')
    time.sleep(time)
    timestop()

def Autopilot(direction):
    print('Autopilot ...')
    strlength1=len(direction)
    # strlength2 = distance.len()
    if strlength1 !=0:
        for i in range(0,strlength1):
            if direction[i]=='Forward':
                forward()
                # self.timerun(float(distance[i]))
                timestop()
            elif direction[i]=='turnR':
                right_90()
                # self.timerun(float(distance[i]))
            elif direction[i]=='turnL':
                left_90()
                # self.timerun(float(distance[i]))
    else:
        print('error no arguments ...')

def Data_processing():
    print('Data_processing ...')
    a,nodelist=pso.commandlistoutput()
    optimizationalgorithm.drawGraph(nodelist)
    print(a)
    Autopilot(a)

def start_up(data):
    # print("start_up")
    if data=='1':
        forward()
    elif data=='2':
        left()
    elif data=='3':
        stop()
    elif data=='4':
        right()
    elif data=='5':
        reverse()
    elif data=='6':
        square()
    elif data=='7':
        Data_processing()


def service_client(new_socket):
    # 为这个客户端返回数据
    # 1.接收浏览器发过来的请求，即http请求
    # GET / HTTP/1.1
    request = new_socket.recv(1024).decode('utf-8')
    request_header_lines = request.splitlines()
    print(request_header_lines)
    data = request_header_lines[-1]
    # print(data)
    # start_up(data)
    # ret = re.match(r'[^/]+(/[^ ]*)', request_header_lines[0])
    ret =  list(request_header_lines[0].split(' '))[1]
    method = list(request_header_lines[0].split(' '))[0]
    path_name = "/"

    if method == 'GET':
        if ret:
            path = ret
            path_name = urllib.parse.unquote(path)  # 浏览器请求的路径中带有中文，会被自动编码，需要先解码成中文，才能找到后台中对应的html文件
            print("请求路径：{}".format(path_name))

        if path_name == "/":  # 用户请求/时，返回咖啡.html页面
            path_name = "/咖啡.html"

        # 2.返回http格式的数据给浏览器
        file_name = 'E:/pythonProject2/httpweb/HTML/' + path_name
        try:
            f = open(file_name, 'rb')
        except:
            response = "HTTP/1.1 404 NOT FOUND\r\n"
            response += "\r\n"
            response += "------file not found------"
            new_socket.send(response.encode("utf-8"))
        else:
            html_content = f.read()
            f.close()
            # 准备发给浏览器的数据 -- header
            response = "HTTP/1.1 200 OK\r\n"
            response += "\r\n"
            new_socket.send(response.encode("utf-8"))
            new_socket.send(html_content)
            # 关闭套接字
    if method == 'PUT':
        if ret:
            path = ret
            path_name = urllib.parse.unquote(path)  # 浏览器请求的路径中带有中文，会被自动编码，需要先解码成中文，才能找到后台中对应的html文件
            print("请求路径：{}".format(path_name))
        if path_name == "/":  # 用户请求/时，返回咖啡.html页面
            path_name = "/咖啡.html"

        # 2.返回http格式的数据给浏览器
        file_name = 'E:/pythonProject2/httpweb/HTML/' + path_name

        response = "HTTP/1.1 200 OK\r\n"
        response += "\r\n"
        new_socket.send(response.encode("utf-8"))
        new_socket.send(file_name.encode("utf-8")+'    data:'.encode("utf-8")+data.encode("utf-8"))
    if method == 'POST':
        if ret:
            path = ret
            path_name = urllib.parse.unquote(path)  # 浏览器请求的路径中带有中文，会被自动编码，需要先解码成中文，才能找到后台中对应的html文件
            # print("请求路径：{}".format(path_name))
            print(data)
            start_up(data)
        if path_name == "/":  # 用户请求/时，返回咖啡.html页面
            path_name = "/咖啡.html"

        # 2.返回http格式的数据给浏览器
        file_name = list(request_header_lines[0].split(' '))[1] +'test.txt'
        content = data.encode('utf-8')
        # #将图片转换为josn
        # data = {}
        # with open('map.png', mode='rb') as file:
        #     img = file.read()
        # data['img'] = base64.encodebytes(img).decode('utf-8')
        # 将照片转化成base64
        a=image_to_base64('ha.png')
        response = "HTTP/1.1 200 OK"+a+" \r\n"
        response += "\r\n"
        with open(file_name, 'ab') as f:
            f.write(content)
        new_socket.send(response.encode("utf-8"))
        new_socket.send("finish".encode("utf-8"))
    # 关闭套接字
    new_socket.close()


def main():
    # 用来完成整体的控制
    # 1.创建套接字
    tcp_server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    # 2.绑定
    tcp_server_socket.bind(("0.0.0.0", 8100))
    # 3.变为监听套接字
    tcp_server_socket.listen(128)
    while True:
        # 4.等待新客户端的链接
        new_socket, client_addr = tcp_server_socket.accept()
        # 5.为这个客户端服务
        print("为",client_addr,"服务")
        t = threading.Thread(target=service_client, args=(new_socket,))
        t.start()

    # 关闭监听套接字
    tcp_server_socket.close()


if __name__ == '__main__':
    main()
