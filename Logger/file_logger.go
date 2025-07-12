package main

import (
	"os"
)

type LogFileOut struct {
	path string
}

func NewLogFileOut(path string) *LogFileOut {
	return &LogFileOut{path: path}
}

func (lg *LogFileOut) Log(message *LogMessage) error {
	file, err := os.OpenFile(lg.path, os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		return err
	}
	defer func(file *os.File) {
		err := file.Close()
		if err != nil {

		}
	}(file)
	_, err = file.WriteString(message.String() + "\n")
	return err
}
