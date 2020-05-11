public class StreamProcessing {
    public static void main(String[] args) {
        Stream stream = new Stream();
        StreamFiller streamFiller = new StreamFiller(stream);

        StreamPrinter streamPrinter = new StreamPrinter();
        streamPrinter.setStream(stream);


        // test multiple times...
        for (int i = 0; i < 3; i++) {
            streamFiller.fillStream();
            streamPrinter.printStream();
        }
    }
}

class StreamFiller {
    private final WritableStream stream;

    StreamFiller(WritableStream stream) {
        if (stream == null) {
            throw new NullPointerException("stream can't be null");
        }
        this.stream = stream;
    }

    public void fillStream() {
        stream.writeString("This is a");
        stream.writeString(" stream.");
    }
}

class StreamPrinter {
    //Exercise 4
    private ReadableStream stream;

    //Exercise 4
    public void setStream(ReadableStream stream) {
        this.stream = stream;
    }

    public void printStream() {
        //Exercise 4:
        if (stream == null) {
            throw new NullPointerException("stream can't null: " + this.getClass().getSimpleName());
        }

        char ch = stream.readChar();
        while (ch != 0) {
            System.out.print(ch);
            ch = stream.readChar();
        }
    }
}

// Exercise 3.1
interface WritableStream {
    void writeString(String str);
}

// Exercise 3.1
interface ReadableStream {
    char readChar();
}

interface IStream extends WritableStream, ReadableStream {
}

class Stream implements IStream {
    private String content = "";
    int index = 0;

    public char readChar() {
        if (index < content.length())
            return content.charAt(index++);
        else
            return 0;
    }

    public void writeString(String str) {
        content += str;
    }
}
