from gpiozero import Motor
import time


class PaddyRobot:
    def __init__(self):
        self.flmotor = Motor(forward=16, backward=20, enable=21)
        self.frmotor = Motor(forward=13, backward=19, enable=26)
        self.blmotor = Motor(forward=5, backward=6, enable=12)
        self.brmotor = Motor(forward=17, backward=27, enable=22)
        self.STRAIGHT_LINE_POWER = 0.2

    def left(self):
        print('Left ...')
        self.flmotor.backward(self.STRAIGHT_LINE_POWER)
        self.frmotor.forward(self.STRAIGHT_LINE_POWER)
        self.blmotor.backward(self.STRAIGHT_LINE_POWER)
        self.brmotor.forward(self.STRAIGHT_LINE_POWER)

    def right(self):
        print('Right ...')
        self.flmotor.forward(self.STRAIGHT_LINE_POWER)
        self.frmotor.backward(self.STRAIGHT_LINE_POWER)
        self.blmotor.forward(self.STRAIGHT_LINE_POWER)
        self.brmotor.backward(self.STRAIGHT_LINE_POWER)

    def forward(self):
        print('Forwarding ...')
        self.flmotor.forward(self.STRAIGHT_LINE_POWER)
        self.frmotor.forward(self.STRAIGHT_LINE_POWER)
        self.blmotor.forward(self.STRAIGHT_LINE_POWER)
        self.brmotor.forward(self.STRAIGHT_LINE_POWER)

    def reverse(self):
        print('backward ...')
        self.flmotor.backward(self.STRAIGHT_LINE_POWER)
        self.frmotor.backward(self.STRAIGHT_LINE_POWER)
        self.blmotor.backward(self.STRAIGHT_LINE_POWER)
        self.brmotor.backward(self.STRAIGHT_LINE_POWER)

    def stop(self):
        print('Stopping ...')
        self.flmotor.stop()
        self.frmotor.stop()
        self.blmotor.stop()
        self.brmotor.stop()


class RobotController():
    def __init__(self, paddyRobot: PaddyRobot):
        self.paddyRobot = paddyRobot

    def right90(self):
        self.paddyRobot.right()
        time.sleep()
        self.paddyRobot.stop()

    def left90(self):
        print('left 90 ...')
        self.paddyRobot.left()
        time.sleep(1)
        self.paddyRobot.stop()

    def square(self):
        straight_delay = 1
        print('square ...')
        paddyRobot = self.paddyRobot
        for _ in range(4):
            paddyRobot.forward()
            time.sleep(straight_delay)
            self.left_90()
