public class StreamProcessing {
    public static void main(String[] args) {
        Stream stream = new Stream();
        StreamFiller.fillStream(stream);
        StreamPrinter.printStream(stream);

        // Exercise 3.3
        StreamFiller.fillStream(stream);
        MyStreamApplier.applyStream(stream, StreamPrinter::printStream);
    }
}

class StreamFiller {
    public static void fillStream(WritableStream stream) {
        stream.writeString("This is a");
        stream.writeString(" stream.");
    }
}

class StreamPrinter {
    public static void printStream(ReadableStream stream) {
        char ch = stream.readChar();
        while (ch != 0) {
            System.out.print(ch);
            ch = stream.readChar();
        }
    }
}

class MyStreamApplier {
    public static void applyStream(ApplicableStream stream, StreamApplier streamApplier) {
        stream.apply(streamApplier);
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

// Exercise 3.3
interface StreamApplier {
    void apply(Stream stream);
}

// Exercise 3.3
interface ApplicableStream {
    void apply(StreamApplier streamApplier);
}

interface IStream extends WritableStream, ReadableStream, ApplicableStream {}

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

    // Exercise 3.3
    public void apply(StreamApplier streamApplier) {
        streamApplier.apply(this);
    }
}
