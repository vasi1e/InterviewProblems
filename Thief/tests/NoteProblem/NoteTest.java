package NoteProblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {
    private Note note;

    @BeforeEach
    public void init() {
        note = new Note();
    }

    @Nested
    @DisplayName("Testing possibility of writing note")
    public class isPossible {

        @Test
        @DisplayName("No wanted text/No magazine")
        void isPossibleEmptyNote() {
            boolean noNote = note.isPossible("", "aa");
            boolean noMagazine = note.isPossible("aa", "");

            assertTrue(noNote, "If there is no node it could be possible");
            assertFalse(noMagazine, "If there is no magazine it couldn't be possible");
        }

        @Test
        @DisplayName("Only one wanted letter")
        void isPossibleOne() {
            assertAll(
                    () -> assertTrue(note.isPossible("a", "a"), "Check if you could write 'a' with 'a'"),
                    () -> assertTrue(note.isPossible("u", "u"), "Check if you could write 'u' with 'u'"),
                    () -> assertTrue(note.isPossible("d", "abd"), "Check if you could write 'd' with 'abd'"),
                    () -> assertFalse(note.isPossible("a", "b"), "Check if you could write 'a' with 'b'"),
                    () -> assertFalse(note.isPossible("z", "c"), "Check if you could write 'z' with 'c'"),
                    () -> assertFalse(note.isPossible("m", "uas"), "Check if you could write 'm' with 'uas'")
            );
        }

        @Test
        @DisplayName("Duplicate wanted letters")
        void isPossibleWithDuplicates() {
            assertAll(
                    () -> assertTrue(note.isPossible("aa", "aa"), "Check if you could write 'aa' with 'aa'"),
                    () -> assertTrue(note.isPossible("uu", "uasu"), "Check if you could write 'uu' with 'uasu'"),
                    () -> assertFalse(note.isPossible("bb", "b"), "Check if you could write 'bb' with 'b'"),
                    () -> assertFalse(note.isPossible("zz", "zma"), "Check if you could write 'zz' with 'zma'")
            );
        }

        @Test
        @DisplayName("Random tests")
        void isPossibleRandom() {
            assertAll(
                    () -> assertTrue(note.isPossible("azbza", "zzbaa"), "Check if you could write 'azbza' with 'zzbaa'"),
                    () -> assertTrue(note.isPossible("usksoand", "uasusnkooedyb"), "Check if you could write 'usksoand' with 'usksoand'"),
                    () -> assertFalse(note.isPossible("imvasil", "vasil"), "Check if you could write 'bb' with 'b'"),
                    () -> assertFalse(note.isPossible("hiiih", "hija"), "Check if you could write 'zz' with 'zma'")
            );
        }
    }
}