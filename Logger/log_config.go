package main

type LogConfig struct {
	logLevel  LogLevel
	logSource LogSource
}

func NewLogConfig(level LogLevel, lg LogSource) *LogConfig {
	return &LogConfig{
		logLevel:  level,
		logSource: lg,
	}
}

func (c *LogConfig) SetLogConfig(level LogLevel, lg LogSource) {
	c.logLevel = level
	c.logSource = lg
}
