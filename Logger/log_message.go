package main

import (
	"fmt"
	"time"
)

type LogMessage struct {
	level     LogLevel
	message   string
	timeStamp int64
}

func NewLogMessage(level LogLevel, message string) *LogMessage {
	return &LogMessage{level, message, time.Now().UTC().UnixMilli()}
}

func (message *LogMessage) String() string {
	return fmt.Sprintf("[%s] %d - %s", message.level, message.timeStamp, message.message)
}
