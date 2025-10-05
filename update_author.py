import os
import random

# Define the directory containing the code files
directories = ['src']

# Define the author name to be added
author_name = 'keshav122'

def java_has_author(file_path, author_name):
    with open(file_path, 'r') as file:
        content = file.read()
        return f'Author: {author_name}' in content

def nonjava_has_author(file_path, author_name):
    with open(file_path, 'r') as file:
        content = file.read()
        return f'Author: {author_name}' in content

def add_author_comment_to_java(file_path, author_name):
    with open(file_path, 'r+') as file:
        content = file.read()
        file.seek(0, 0)
        file.write(f'/*Author: {author_name} */\n{content}')

def append_author_comment(file_path, author_name):
    with open(file_path, 'a') as file:
        file.write(f'\n# Author: {author_name}\n')

# Get a list of all files in the specified directories
files = []
for directory in directories:
    for root, _, filenames in os.walk(directory):
        for filename in filenames:
            files.append(os.path.join(root, filename))

random.shuffle(files)  # Shuffle to randomize selection order

for file_to_update in files:
    if file_to_update.endswith('.java'):
        if not java_has_author(file_to_update, author_name):
            add_author_comment_to_java(file_to_update, author_name)
            print(f'Updated author name in file: {file_to_update}')
            break
    else:
        if not nonjava_has_author(file_to_update, author_name):
            append_author_comment(file_to_update, author_name)
            print(f'Updated author name in file: {file_to_update}')
            break
else:
    print('No file needed updating. Author already present in all files.')
