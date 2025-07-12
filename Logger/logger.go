package main

import "sync"

type Logger struct {
	config *LogConfig
	mu     sync.RWMutex
}

var (
	instance *Logger
	once     sync.Once
)

func GetLogger() *Logger {
	once.Do(func() {
		instance = &Logger{
			config: NewLogConfig(LogLevelInfo, NewLogStdOut()),
		}
	})
	return instance
}

func (L *Logger) SetConfig(config *LogConfig) {
	L.mu.Lock()
	defer L.mu.Unlock()
	L.config = config
}

func (L *Logger) log(level LogLevel, message string) error {
	L.mu.RLock()
	if level < L.config.logLevel {
		L.mu.RUnlock()
		return nil
	}
	lg := L.config.logSource
	L.mu.RUnlock()

	return lg.Log(NewLogMessage(level, message))
}

func (L *Logger) Debug(message string) error {
	return L.log(LogLevelDebug, message)
}
func (L *Logger) Info(message string) error {
	return L.log(LogLevelInfo, message)
}
func (L *Logger) Warn(message string) error {
	return L.log(LogLevelWarn, message)
}
func (L *Logger) Error(message string) error {
	return L.log(LogLevelError, message)
}
func (L *Logger) Fatal(message string) error {
	return L.log(LogLevelFatal, message)
}
