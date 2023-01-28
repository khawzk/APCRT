from flask import Flask, request, jsonify
# from flask_socketio import SocketIO, join_room, emit, send
from paddyrobot import PaddyRobot, RobotController


app = Flask(__name__)
# socketio = SocketIO(app)
paddyRobot = PaddyRobot()
controller = RobotController(paddyRobot)


@app.route("/manual/left", methods=['GET'])
def left():
    paddyRobot.left()
    return "OK"


@app.route("/manual/right", methods=['GET'])
def right():
    paddyRobot.right()
    return "OK"


@app.route("/manual/forward", methods=['GET'])
def forward():
    paddyRobot.forward()
    return "OK"


@app.route("/manual/backward", methods=['GET'])
def backward():
    paddyRobot.backward()
    return "OK"


@app.route("/manual/stop", methods=['GET'])
def stop():
    paddyRobot.stop()
    return "OK"


@app.route("/left90")
def left90():
    controller.left90()
    return "OK"


@app.route("/right90")
def right90():
    controller.right90()
    return "OK"


@app.route("/squareleft")
def squareleft():
    controller.square_left()
    return "OK"

@app.route("/squareright")
def squareright():
    controller.square_right()
    return "OK"

@app.route("/zigzag")
def zigzag():
    controller.zigzag()
    return "OK"

# @socketio.on("set_axis")
# def set_axis(data):
#     print(data)
#     controller.set_axis(x=data["x"], y=data["y"])

if __name__ == "__main__":
    paddyRobot = PaddyRobot()
    controller = RobotController(paddyRobot)

    # socketio.run(app, debug=True, host="0.0.0.0", port=8100)
    app.run(debug=True, host="0.0.0.0", port=8100)
