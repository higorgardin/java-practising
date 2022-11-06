package br.com.practising.functionalinterfaces;

import java.util.stream.Stream;

/**
 * @author Higor Gardin
 * @since 06/11/2022 - 12:33
 */
public class RunnableDemo {

    public static void main(String... args) {

        // Implementing runnable interface
        final RunnableImpl runnableImpl = new RunnableImpl();

        // Creating handle of onClose on stream
        final Stream<Pojo> streamEx = Stream.of(new Pojo()).onClose(runnableImpl);

        // Closing the stream
        streamEx.close();
    }

    private static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("Then I run!");
        }
    }

    private static class Pojo {
        Pojo() {}
    }

}
