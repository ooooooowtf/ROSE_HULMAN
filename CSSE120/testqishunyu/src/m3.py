"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Xiaoxiao Wang, Chaobo Li, Tianyi Wen, Huaiqian Shou (all of them).

The primary author of this module is:  Xiaoxiao Wang.
"""
# Done: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m2
import m4
import time
import tkinter
from tkinter import ttk
import rosebot.standard_rosebot as rb


def my_frame(root, dc):
    """
    Constructs and returns a   ttk.Frame   on the given root window.
    The frame contains all of this module's widgets.
    Does NOT   grid   the Frame, since the caller will do that.
    Also sets up callbacks for this module's widgets.

    The first argument is the  root  window (a tkinter.Tk object)
    onto which the   ttk.Frame  returned from this function
    will be placed.  The second argument is the shared DataContainer
    object that is CONSTRUCTED in m0 but USED in m1, m2, m3 and m4.

    Preconditions:
      :type root: tkinter.Tk
      :type dc:   m0.DataContainer
    """
# move forward

    frame = ttk.Frame(root, padding=10)
    speedlable = ttk.Label(frame)
    speedlable['text'] = 'speed'
    speed_entry = ttk.Entry(frame)
    speedlable.grid(), speed_entry.grid()
    distancelable = ttk.Label(frame)
    distancelable['text'] = 'distance'
    distance_entry = ttk.Entry(frame)
    distancelable.grid(), distance_entry.grid()
    go_straight_button = ttk.Button(frame, text='Go forward')
    go_straight_button.grid()
    go_straight_button['command'] = lambda: go_straight(dc, distance_entry, speed_entry)

# print the sensor values

    sensor_reading_button = ttk.Button(frame, text='Get Sensor Reading')
    sensor_reading_button.grid()
    sensor_reading_button['command'] = lambda: get_sensor_reading(dc)

# set threshold

    thresholdlable = ttk.Label(frame)
    thresholdlable['text'] = 'set threshold'
    thresholdlable.grid()
    threshold_entry = ttk.Entry(frame)
    threshold_entry.grid()

# robot moves until the threshold is exceed
# ## the sensor reading on the table is about 70, 150, 120
# ## the sensor reading on the bondary is above 900

    move_to_threshold_button = ttk.Button(frame,
                                          text='Move until threshold is reached')
    move_to_threshold_button.grid()
    move_to_threshold_button['command'] = lambda: move_to_threshold(dc, threshold_entry)

# get camera reading

    camera_reading_button = ttk.Button(frame,
                                          text='Get camera reading')
    camera_reading_button.grid()
    camera_reading_button['command'] = lambda: get_camera_reading(dc)

#     testcamera_entry = ttk.Entry(frame)
#     testcamera_entry.grid()
#     center = testcamera_entry.get

# give proximity sensor reading

    proximity_sensor_reading_button = ttk.Button(frame, text='Get proximity sensor reading')
    proximity_sensor_reading_button.grid()
    proximity_sensor_reading_button['command'] = lambda: get_proximity_sensor_reading(dc)

# enter kp ki kd

    kplable = ttk.Label(frame)
    kplable['text'] = 'set kp for camera (0.03)'
    kplable.grid()
    kp_entry = ttk.Entry(frame)
    kp_entry.grid()

    kdlable = ttk.Label(frame)
    kdlable['text'] = 'set kd for camera (0.01)'
    kdlable.grid()
    kd_entry = ttk.Entry(frame)
    kd_entry.grid()

    kplable2 = ttk.Label(frame)
    kplable2['text'] = 'set kp for sensor (0.02)'
    kplable2.grid()
    kp_entry2 = ttk.Entry(frame)
    kp_entry2.grid()

    kdlable2 = ttk.Label(frame)
    kdlable2['text'] = 'set kd for sensor(0.01)'
    kdlable2.grid()
    kd_entry2 = ttk.Entry(frame)
    kd_entry2.grid()

# robot uses its camera to follow an object

    follow_the_object_button = ttk.Button(frame,
                                          text='Follow the object(bangbang)')
    follow_the_object_button.grid()
    follow_the_object_button['command'] = lambda: follow_the_object_bangbang(dc)

    follow_the_object_button2 = ttk.Button(frame,
                                          text='Follow the object(PID)')
    follow_the_object_button2.grid()
    follow_the_object_button2['command'] = lambda: follow_the_object_PID(dc, kp_entry, kd_entry, kp_entry2, kd_entry2)

# robot moves to trace a circle
    circle_button = ttk.Button(frame, text='Move in a circle')
    circle_button.grid()
    circle_button['command'] = lambda: circle(dc)

    return frame


def go_straight(dc, distance_entry, speed_entry):
    dis = int(distance_entry.get())
    speed = int(speed_entry.get())
#     print(dis, speed)
    time1 = dis * 5 / speed
    dc.robot.motor_controller.drive_pwm(speed, speed)
    time.sleep(time1)
    dc.robot.motor_controller.stop()


def get_sensor_reading(dc):
    left_reflectance = dc.robot.sensor_reader.left_reflectance_sensor.read()
    right_reflectance = dc.robot.sensor_reader.right_reflectance_sensor.read()
    middle_reflectance = dc.robot.sensor_reader.middle_reflectance_sensor.read()

    print('Sensor values:')
    print(left_reflectance, right_reflectance, middle_reflectance)
    return([left_reflectance, right_reflectance, middle_reflectance])


def move_to_threshold(dc, threshold_entry):
    threshold = int(threshold_entry.get())
    seq = get_sensor_reading(dc)
    for k in range(len(seq) - 1):
        reading_max = seq[k]
        if seq[k + 1] > reading_max:
            reading_max = seq[k]
    while True:
        if reading_max > threshold:
            dc.robot.motor_controller.stop()
            break
        dc.robot.motor_controller.drive_pwm(30, 30)
        time.sleep(0.2)
        seq = get_sensor_reading(dc)
        for k in range(len(seq) - 1):
            reading_max = seq[k]
            if seq[k + 1] > reading_max:
                reading_max = seq[k]


def get_camera_reading(dc):
    block = dc.robot.camera.get_block(1)
    print(block)
    if block:
        print(block.x, block.y, block.width, block.height)
        return block.x


def get_proximity_sensor_reading(dc):
    left_proximity_reading = dc.robot.sensor_reader.left_proximity_sensor.read()
    right_proximity_reading = dc.robot.sensor_reader.right_proximity_sensor.read()
    front_proximity_reading = dc.robot.sensor_reader.front_proximity_sensor.read()

    print('Proximity sensor values:')
    print(left_proximity_reading, front_proximity_reading, right_proximity_reading)
    return(front_proximity_reading)


def follow_the_object_bangbang(dc):
    while True:
        x = get_camera_reading(dc)
        dis = get_proximity_sensor_reading(dc)
        if x is not None:
            if x < 100:
                dc.robot.motor_controller.drive_pwm(-40, 40)
                time.sleep(0.05)
            if x > 200:
                dc.robot.motor_controller.drive_pwm(40, -40)
                time.sleep(0.05)
            if x > 100 and x < 200:
                dc.robot.motor_controller.stop()
            if dis < 200:
                dc.robot.motor_controller.drive_pwm(40, 40)
                time.sleep(0.05)
            if dis > 500:
                dc.robot.motor_controller.drive_pwm(-40, -40)
                time.sleep(0.05)
            if dis > 200 and dis < 500:
                dc.robot.motor_controller.stop()
        else:
            dc.robot.motor_controller.stop()
        if dc.robot.sensor_reader.left_bump_sensor.read() == 0:
            break


def follow_the_object_PID(dc, kp_entry, kd_entry, kp_entry2, kd_entry2):

    error_error_x = 0
    error_error_dis = 0
    kp = float(kp_entry.get())
    kd = float(kd_entry.get())
    kp2 = float(kp_entry2.get())
    kd2 = float(kd_entry2.get())
#     print(kp, kd)
    while True:
        x = get_camera_reading(dc)
        dis = get_proximity_sensor_reading(dc)
#         print(x, dis)
        threshold_x = 150
        base_v = 30
        if x is not None:
            if x < 100 or x > 200:
                error_x = x - threshold_x
                error_error_x = error_x - error_error_x
                v_x = base_v + error_x * kp + error_error_x * kd
                v_x = int(v_x)
#                 print(v_x, error_x, error_error_x, kp_x, kd_x)
                dc.robot.motor_controller.drive_pwm(v_x, -v_x)
                time.sleep(0.1)
            if x > 100 and x < 200:
                dc.robot.motor_controller.stop()

        if dis > 500:
            threshold_dis = 450
            error_dis = dis - threshold_dis
            error_error_dis = error_dis - error_error_dis
            v = base_v + error_dis * kp2 + error_error_dis * kd2
            v = int(v)
#                 print(v, error, error_error, kp, kd)
            dc.robot.motor_controller.drive_pwm(-v, -v)
        if dis < 400:
            threshold_dis = 450
            error_dis = threshold_dis - dis
            error_error_dis = error_dis - error_error_dis
            v = base_v + error_dis * kp2 + error_error_dis * kd2
            v = int(v)
#                 print(v, error, error_error, kp, kd)
            dc.robot.motor_controller.drive_pwm(v, v)

        if dc.robot.sensor_reader.left_bump_sensor.read() == 0:
            dc.robot.motor_controller.stop()
            break

def circle(dc):
    dc.robot.motor_controller.drive_pwm(70, 30)
    time.sleep(10)
    dc.robot.motor_controller.stop()


# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    m0.main()
