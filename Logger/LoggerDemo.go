package main

import "fmt"

func main() {
	logger := GetLogger()
	lg := NewLogStdOut()

	logger.SetConfig(NewLogConfig(LogLevelWarn, lg))

	logger.Debug("This is a debug log")
	logger.Info("This is an info log")
	logger.Warn("This is a warn log")
	logger.Error("This is a error log")

	if err := logger.Debug("This is a debug log"); err != nil {
		fmt.Printf("Error printing debug log: %v\n", err)
	}

	if err := logger.Info("This is a warn log"); err != nil {
		fmt.Printf("Error printing warn log: %v\n", err)
	}
}
