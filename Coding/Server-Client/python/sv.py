import socket
from os import curdir, sep

from http.server import HTTPServer,CGIHTTPRequestHandler

import json
from gpiozero import Motor
#import curses

flmotor = Motor(forward=16, backward=20, enable=21)
frmotor = Motor(forward=13, backward=19, enable=26)
blmotor = Motor(forward=5, backward=6, enable=12)
brmotor = Motor(forward=17, backward=27, enable=22)

STRAIGHT_LINE_POWER = 0.3
TURNING_POWER = 0.3

class HttpHandler(CGIHTTPRequestHandler):

    def do_GET(self):
        try:
            f = open(curdir + sep + self.path)
            print(self.path)
            print('This is a GET method!')
            self.send_response(200)
            self.send_header('Content-type',
                             'text/html')
            self.end_headers()
            self.wfile.write(f.read())
            f.close()
        except IOError:
            self.send_error(404, 'File Not Found:%s' % self.path)

    def do_POST(self):
        try:
            # print(self.path)
            print('This is a POST method!')
            self.data = self.request.recv(1024).strip()
            self.data = json.loads(self.data)
            # print("information:",self.data)
            self.start_up(self.data)
            sendData = {}
            if self.path == '/getfile':
                f = open(curdir + sep + '/test_body.txt')
                fileContent = f.read()
                sendData['content'] = fileContent
                f.close()
            self.send_response(200)
            self.send_header('Content-type',
                             'text/html')
            self.end_headers()
            self.wfile.write(sendData)
        except:
            self.send_error(404, 'Invalid request:%s!' % self.path)

    def do_PUT(self):
        try:
            print(self.path)
            print('This is a PUT method!')
            self.data = self.request.recv(1024).strip()
            print(self.data)
            sendData = {}
            if self.path == '/getfile':
                f = open(curdir + sep + '/test_body.txt')
                fileContent = f.read()
                sendData['content'] = fileContent
                f.close()
            self.send_response(200)
            self.send_header('Content-type',
                             'text/html')
            self.end_headers()
            self.wfile.write(sendData)
        except:
            self.send_error(404, 'Invalid request:%s!' % self.path)



    def left(self):
        print('Left ...')
        flmotor.backward(STRAIGHT_LINE_POWER)
        frmotor.forward(STRAIGHT_LINE_POWER)
        blmotor.backward(STRAIGHT_LINE_POWER)
        brmotor.forward(STRAIGHT_LINE_POWER)

    def right(self):
        print('Right ...')
        flmotor.forward(STRAIGHT_LINE_POWER)
        frmotor.backward(STRAIGHT_LINE_POWER)
        blmotor.forward(STRAIGHT_LINE_POWER)
        brmotor.backward(STRAIGHT_LINE_POWER)

    def forward(self):
        print('Forwarding ...')
        flmotor.forward(STRAIGHT_LINE_POWER)
        frmotor.forward(STRAIGHT_LINE_POWER)
        blmotor.forward(STRAIGHT_LINE_POWER)
        brmotor.forward(STRAIGHT_LINE_POWER)

    def reverse(self):

        print('backward ...')
        flmotor.backward(STRAIGHT_LINE_POWER)
        frmotor.backward(STRAIGHT_LINE_POWER)
        blmotor.backward(STRAIGHT_LINE_POWER)
        brmotor.backward(STRAIGHT_LINE_POWER)

    def stop(self):
        print('Stopping ...')
        flmotor.stop()
        frmotor.stop()
        blmotor.stop()
        brmotor.stop()

    def camera(self):
        print('camera ...')

    def start_up(self, data):
        # print("start_up")
        if data==1:
            self.forward()
        elif data==2:
            self.left()
        elif data==3:
            self.stop()
        elif data==4:
            self.right()
        elif data==5:
            self.reverse()
        elif data==6:
            self.camera()

def main():
    try:
        localIp = socket.gethostbyname(socket.gethostname())
        print(localIp)
        server_address = ('0.0.0.0', 5000)
        http_server = HTTPServer(server_address, HttpHandler)
        sa = http_server.socket.getsockname()
        print("Serving HTTP on", sa[0], "port", sa[1], "...")
        print('Press ^C once or twice to quit.')
        http_server.serve_forever()
    except KeyboardInterrupt:\
        print('^C received,shutting down server.')
    http_server.socket.close()

if __name__ == '__main__':

    main()

