import sys, os
from subprocess import call
from datetime import date, timedelta
from random import randint

username = sys.argv[1]
password = sys.argv[2]
repository = sys.argv[3]
hasTemplate = False
if len(sys.argv) == 5:
	template = sys.argv[4]
	hasTemplate = True

call('git init', shell=True)
call('git remote add origin https://' + username + ':' + password + '@github.com/' + username + '/' + repository + '.git', shell=True)

time = '12:00:00'
offset = '-0500'
minimum = 0
maximum = 1
filename = 'README.MD'
message = 'test'

half = ' ' + time + ' ' + offset
current = date.today() - timedelta(days=140)
if hasTemplate:
	while current.weekday() != 6:
		current = current + timedelta(days=1)
	rowCounter = current
	tFile = open(template)
	tLines = tFile.readlines()
	tFile.close()
	for i in range(0, 5):
		for k in range(0, len(tLines[i]) - 1):
			for n in range(0, (maximum / 5 * (int(tLines[i][k]) - 1)) + randint(0, maximum / 5)):
				if n== 0:
					break
				if int(tLines[i][k]) == 0:
					break
				complete = str(current) + half + ':' + str(n + 1)
				readme = open(filename, 'w+')
				readme.write(complete)
				call('git add ' + filename, shell=True)
				call('git commit --date="' + complete + '" -m "' + message + '"', stdout=open(os.devnull, 'w'), shell=True)
				print 'Committing: ' + complete
			call('git push origin master', shell=True)
			current = current + timedelta(days=7)
		current = rowCounter + timedelta(days=1)
		rowCounter = rowCounter + timedelta(days=1)
else:
	for i in range(0, 365):
		for k in range(0, randint(minimum, maximum)):
			complete = str(current) + half + ':' + str(k + 1)
			readme = open(filename, 'w+')
			readme.write(complete)
			# message = complete
			call('git add ' + filename, shell=True)
			call('git commit --date="' + complete + '" -m "' + message + '"', stdout=open(os.devnull, 'w'), shell=True)
			print 'Committing: ' + complete
		call('git push origin master', shell=True)
		current = current + timedelta(days=1)
readme.close()
