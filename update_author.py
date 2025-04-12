import os
import random

# Define the directory containing the code files
directories = ['CodeStudio', 'Contests', 'DSA_Series', 'Exercism', 'LeetCode_Practice', 'Webinars']

# Define the author name to be added
author_name = 'keshav122'

# Function to add the author comment at the class level for Java files
def add_author_comment_to_java(file_path, author_name):
    with open(file_path, 'r+') as file:
        content = file.read()
        file.seek(0, 0)
        file.write(f'/*Author: {author_name} */\n{content}')

# Function to append the author comment for non-Java files
def append_author_comment(file_path, author_name):
    with open(file_path, 'a') as file:
        file.write(f'\n# Author: {author_name}\n')

# Get a list of all files in the specified directories
files = []
for directory in directories:
    for root, _, filenames in os.walk(directory):
        for filename in filenames:
            files.append(os.path.join(root, filename))

# Select a random file from the list
file_to_update = random.choice(files)

# Check the file extension and update the file with the appropriate author comment
if file_to_update.endswith('.java'):
    add_author_comment_to_java(file_to_update, author_name)
else:
    append_author_comment(file_to_update, author_name)

print(f'Updated author name in file: {file_to_update}')
