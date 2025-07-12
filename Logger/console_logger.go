package main

import "fmt"

type LogStdOut struct{}

func NewLogStdOut() *LogStdOut {
	return &LogStdOut{}
}

func (lg *LogStdOut) Log(message *LogMessage) error {
	fmt.Println(message.String())
	return nil
}
