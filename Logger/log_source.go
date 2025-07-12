package main

type LogSource interface {
	Log(logMessage *LogMessage) error
}
