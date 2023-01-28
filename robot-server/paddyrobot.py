from gpiozero import Motor
import time


class PaddyRobot:
    def __init__(self):
        self.flmotor = Motor(forward=16, backward=20, enable=21)
        self.frmotor = Motor(forward=13, backward=19, enable=26)
        self.blmotor = Motor(forward=5, backward=6, enable=12)
        self.brmotor = Motor(forward=17, backward=27, enable=22)
        self.STRAIGHT_LINE_POWER = 0.3

    def left(self, turn_power=0.3):
        print('Left ...')
        self.flmotor.backward(turn_power)
        self.frmotor.forward(turn_power)
        self.blmotor.backward(turn_power)
        self.brmotor.forward(turn_power)

    def right(self, turn_power=0.3):
        print('Right ...')
        self.flmotor.forward(turn_power)
        self.frmotor.backward(turn_power)
        self.blmotor.forward(turn_power)
        self.brmotor.backward(turn_power)

    def forward(self):
        print('Forwarding ...')
        self.flmotor.forward(self.STRAIGHT_LINE_POWER)
        self.frmotor.forward(self.STRAIGHT_LINE_POWER)
        self.blmotor.forward(self.STRAIGHT_LINE_POWER)
        self.brmotor.forward(self.STRAIGHT_LINE_POWER)

    def backward(self):
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

    def right90(self, turn_delay=1, turn_power=0.35):
        self.paddyRobot.right(turn_power)
        time.sleep(turn_delay)
        self.paddyRobot.stop()

    def left90(self, turn_delay=1, turn_power=0.35):
        print('left 90 ...')
        self.paddyRobot.left(turn_power)
        time.sleep(turn_delay)
        self.paddyRobot.stop()

    def square_left(self):
        straight_delay = 2.0
        turn_delay = 0.7
        print('square ...')
        paddyRobot = self.paddyRobot
        for _ in range(4):
            paddyRobot.forward()
            time.sleep(straight_delay)
            self.left90(turn_delay)

    def square_right(self):
        straight_delay = 2.0
        turn_delay = 0.7
        print('square ...')
        paddyRobot = self.paddyRobot
        for _ in range(4):
            paddyRobot.forward()
            time.sleep(straight_delay)
            self.right90(turn_delay)

    def zigzag(self):
        straight_delay = 3
        turn_straight_delay = 0.9
        turn_delay = 0.75
        print('square ...')
        paddyRobot = self.paddyRobot

        paddyRobot.forward()
        time.sleep(straight_delay)
        self.right90(turn_delay, turn_power=0.28)
        paddyRobot.forward()
        time.sleep(turn_straight_delay)
        self.right90(turn_delay, turn_power=0.28)
        paddyRobot.forward()
        time.sleep(straight_delay)
        self.left90(turn_delay, turn_power=0.3)
        paddyRobot.forward()
        time.sleep(turn_straight_delay)
        self.left90(turn_delay, turn_power=0.3)
        paddyRobot.forward()
        time.sleep(straight_delay)
        self.right90(turn_delay)
        # paddyRobot.forward()
        # time.sleep(turn_straight_delay)
