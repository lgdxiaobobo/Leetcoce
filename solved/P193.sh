# Read from the file file.txt and output all valid phone numbers to stdout.
cat file.txt | grep -P "^\d\d{2}-\d{3}-\d{4}$|^\(\d{3}\) \d{3}-\d{4}$"