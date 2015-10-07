CC := clang


CFLAGS = -g -Wall
LFLAGS = 
TARGET = bench

all: $(TARGET)

$(TARGET): $(TARGET).c
	$(CC) $(CFLAGS) -o $(TARGET) $(TARGET).c $(LFLAGS)

run: $(TARGET)
	./$(TARGET)
