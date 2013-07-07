import sys
from resources.objects import SWGObject
from main import NGECore

def setup():
	return
	
def run(core, actor, target, commandString):
	parsedMsg = commandString.split(' ', 3)
	objService = core.objectService
	containerID = long(parsedMsg[1])
	print str(containerID)
	container = objService.getObject(containerID)
	if target and container and target.getContainer():
		print 'Misc Test'
		oldContainer = target.getContainer()
		oldContainer.transferTo(actor, container, target)
	
	return
	