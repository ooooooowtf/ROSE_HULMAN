"""
The Python Capstone Project.

CSSE 120 - Introduction to Software Development.
Team members: Jonathan Holst, Ben Lewer, Bill Yu.

The primary author of this module is: Ben Lewer.
"""
# DONE: Put the names of ALL team members in the above where indicated.
#       Put YOUR NAME in the above where indicated.

import m0
import m1
import m3
import m4
import time
import random
import math

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

    frame1 = ttk.Frame(root, padding=10)

    print_entry_button = ttk.Button(frame1, text='Compose Music')
    print_entry_button['command'] = (lambda: create_music(dc))
    print_entry_button.grid()

    # Add an extra line
    ttk.Label(frame1, text='').grid()

    label = ttk.Label(frame1, text="Follow the Object using the Camera")
    label.grid()
    camera_frame = ttk.Frame(frame1, padding=10)
    bang_button = ttk.Button(camera_frame, text='Bang-Bang Method')
    PID_button = ttk.Button(camera_frame, text='PID Method')
    bang_button['command'] = lambda: bang_bang_camera(frame1, dc)
    PID_button['command'] = lambda: PID_camera(dc)
    camera_frame.grid()
    bang_button.grid(row=0, column=0)
    PID_button.grid(row=0, column=1)

    # Add an extra line
    ttk.Label(frame1, text='').grid()

    label = ttk.Label(frame1, text="Press Button to display hours")
    label.grid()

    print_entry_button = ttk.Button(frame1, text='Print Hours')
    print_entry_button['command'] = (lambda:
                                     display_all_team_hours(frame1, 3, dc))
    print_entry_button.grid()

    return frame1


def convert_to_string(teammate_number):
    """
    Converts the teammates text file to a string.
    """
    txt = open('..\process\hours-' + str(teammate_number) + '.txt', "r")
    file_contents = txt.read()
    txt.close()
    return file_contents


def display_hour_contents(number_of_teammates, frame):
    """
    Feature 2: Displays all contents of text file. Updated using feature 5
    """
    for k in range(number_of_teammates):
        k = k + 1
        label = ttk.Label(frame, text=convert_to_string(k))
        label.grid(sticky='w')


def get_hours(frame, teammate_number):
    """
    Feature 5: Displays all contents of text file and puts them on the GUI
    """

    file = convert_to_string(teammate_number)
    split_string = file.split('\n')
    total = 0
    sprint1_total = 0
    sprint2_total = 0
    sprint3_total = 0

    ttk.Label(frame, text='').grid()
    label = ttk.Label(frame, text='M' + str(teammate_number) + ' HOURS')
    label.grid()

    for k in range(len(split_string)):
        hours, sprint, _ = split_string[k].split('-')
        total = total + float(hours)

        if sprint[2] == "1":
            sprint1_total = sprint1_total + float(hours)

        elif sprint[2] == "2":
            sprint2_total = sprint2_total + float(hours)

        elif sprint[2] == "3":
            sprint3_total = sprint3_total + float(hours)

    label = ttk.Label(frame, text='Sprint 1: ' + str(sprint1_total))
    label.grid(sticky='e')
    label = ttk.Label(frame, text='Sprint 2: ' + str(sprint2_total))
    label.grid(sticky='e')
    label = ttk.Label(frame, text='Sprint 3: ' + str(sprint3_total))
    label.grid(sticky='e')
    label = ttk.Label(frame, text='Total hours: ' + str(total))
    label.grid()


def display_all_team_hours(frame, number_of_teammates, dc):
    """
    Feature 5: Gets total hours for ALL teammates. Starts with teammate 1.
    """

    for k in range(number_of_teammates):
        get_hours(frame, k + 1)


def create_music(dc):
    """
    Robot composes a song in C Major and then plays it using the buzzer.
    """
    position = 43
    play_music(0.25, position, dc)
    for _ in range(30):
        # chooses another note within 2 octaves.
        position = random.randrange(31, 55, 1)
        R = position % 12
        if R in {1, 3, 5, 8, 10}:
            # Removes sharps and flats from the music
            R = R + 1
        play_music(0.25, position, dc)
        R = position % 12

        if R == 7:
            # plays tonic (C) -> goes to tonic (C)
            play_music(0.25, position, dc)

        elif R == 9:
            # plays supertonic (D)-> goes to mediant (E)
            play_music(0.25, position + 2, dc)

        elif R == 11:
            # plays mediant(E) -> goes to dominant (G)
            play_music(0.25, position + 3, dc)

        elif R == 0:
            # plays subdominant (F) -> goes to dominant (G)
            play_music(0.25, position + 2, dc)

        elif R == 2:
            # plays dominant (G) -> goes to dominant (G)
            play_music(0.25, position, dc)

        elif R == 4:
            # plays submediant (A) -> goes to dominant(G)
            play_music(0.25, position - 2, dc)

        elif R == 6:
            # plays subtonic (B) -> goes to tonic (C)
            play_music(0.25, position + 1, dc)

    play_music(1, 42, dc)
    play_music(2, 43, dc)


def play_music(t, note_num, dc):
    """
    Function to save space and play music with one line instead of needing 3.
    """
    dc.angrybot.buzzer.play_tone(note_num)
    time.sleep(t)
    dc.angrybot.buzzer.stop()


def bang_bang_camera(frame, dc):
    """
    Uses the camera to get x and width values. Uses bang-bang method to follow
    the object.
    """
    desired = 160

    while True:

        actual = dc.angrybot.camera.get_block()

        if actual != None:
            value = actual.x

            if value > desired:
                dc.angrybot.motor_controller.drive_pwm(30, -30)
            elif value < desired:
                dc.angrybot.motor_controller.drive_pwm(-30, 30)
            else:
                continue

            if bumper_stop(dc):
                dc.angrybot.motor_controller.stop()
                break


def PID_camera(dc):
    """
    Uses the camera to get x and width values. Uses PID method to follow
    the object.
    """
    desired = 160
    kp = 0.08
    base = 30
    value = 0

    while True:
        actual = dc.angrybot.camera.get_block()

        if actual != None:
            if actual.x < 1000:
                value = actual.x
            error = abs(value - desired)
            print (error)
            PID = int(error * kp)

            speed = base + PID

            if value > desired:
                dc.angrybot.motor_controller.drive_pwm(speed, -speed)
            elif value < desired:
                dc.angrybot.motor_controller.drive_pwm(-speed, speed)

        if bumper_stop(dc):
            dc.angrybot.motor_controller.stop()
            break

        time.sleep(0.1)

def get_picture_data(dc):
    """
    Gets the x,y,width,heighth data from the camera. Makes sure it doesn't
    return none
    """
    while True:
        block = dc.angrybot.camera.get_block(1)
        print(block)
        if block is not None:
            return(block)


def bang_bang_turn(direction, dc):
    """
    Turns the robot a short amount.
    """
    if direction > 0:
        dc.angrybot.motor_controller.drive_pwm(50, -50)
    else:
        dc.angrybot.motor_controller.drive_pwm(-50, 50)
    dc.angrybot.motor_controller.stop()


def bang_bang_move(direction, dc):
    """
    Moves the robot forward or backward short amount.
    """
    if direction > 0:
        dc.angrybot.motor_controller.drive_pwm(50, 50)
    else:
        dc.angrybot.motor_controller.drive_pwm(-50, -50)
    time.sleep(0.1)
    dc.angrybot.motor_controller.stop()


def PID_turn(direction, PID, dc):
    """
    Takes in error values to adjust speed to get to the desired x value.
    """
    if direction > 0:
        dc.angrybot.motor_controller.drive_pwm(40 + int(PID), -40 + int(PID))
    else:
        dc.angrybot.motor_controller.drive_pwm(-40 + int(PID), 40 + int(PID))
    time.sleep(0.25)
    dc.angrybot.motor_controller.stop()


def PID_move(direction, PID, dc):
    """
    Takes in error values to adjust speed to get to the desired width value.
    """
    if direction > 0:
        dc.angrybot.motor_controller.drive_pwm(40 + PID, 40 + PID)
    else:
        dc.angrybot.motor_controller.drive_pwm(-40 + PID, -40 + PID)
    time.sleep(0.25)
    dc.angrybot.motor_controller.stop()


def bumper_stop(dc):
    """
    Allows the user to press the bumper and stops the robot's task
    """
    if (dc.angrybot.sensor_reader.left_bump_sensor.is_pressed() or
            dc.angrybot.sensor_reader.right_bump_sensor.is_pressed()):
        return True


# ----------------------------------------------------------------------
# If this module is running at the top level (as opposed to being
# imported by another module), then call the 'main' function.
# ----------------------------------------------------------------------
if __name__ == '__main__':
    m0.main()
