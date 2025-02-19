import os
import random

# Define the directory containing the code files
directories = ['CodeStudio', 'Contests','DSA_Series','Exercism','LeetCode_Practice','Webinars']

# Define the author name to be added
author_name = 'keshav122'

# Get a list of all files in the specified directories
files = []
for directory in directories:
    for root, _, filenames in os.walk(directory):
        for filename in filenames:
            files.append(os.path.join(root, filename))

# Select a random file from the list
file_to_update = random.choice(files)

# Update the selected file with the author name
with open(file_to_update, 'a') as file:
    file.write(f'\n# Author: {author_name}\n')

print(f'Updated author name in file: {file_to_update}')
