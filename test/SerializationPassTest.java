import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import contracts.*;
import managers.*;
import problemdomain.*;
import java.io.*;

/**
 * @author Jonghyun Park
 * @version 05 Apr, 2020
 */
class SerializationPassTest implements Serializable {

	private static final long serialVersionUID = 1L;
	private ByteArrayOutputStream bs;
	private ObjectOutputStream os;
	private LinkedListADT user;

	@BeforeEach
	void init() {
		try {
			bs = new ByteArrayOutputStream();
			os = new ObjectOutputStream(bs);

			user = new SLL();
			
			User one = new User(1, "Joe Blow", "jblow@gmail.com", "password");
			user.append(one);
			
			User two = new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef");
			user.append(two);
			
			User three = new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555");
			user.append(three);
			
			User four = new User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999");
			user.append(four);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void serializeTest() {
		try {
			os.reset();
			
			os.writeObject(user);
			
			assertTrue(bs.size() > 0);
			
		} catch (NotSerializableException e) {
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void deserializeTest() {
		try {

			ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bs.toByteArray()));

			LinkedListADT user = (LinkedListADT) is.readObject();

			assertFalse(user.isEmpty());
			assertEquals(4, user.size());

			User exUser1 = new User(1, "Joe Blow", "jblow@gmail.com", null);
			User actUser1 = (User) user.retrieve(0);
			assertEquals(exUser1, actUser1);
			assertTrue(actUser1.isValidPassword(null));

			User exUser2 = new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", null);
			User actUser2 = (User) user.retrieve(1);
			assertEquals(exUser2, actUser2);
			assertTrue(actUser2.isValidPassword(null));

			User exUser3 = new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", null);
			User actUser3 = (User) user.retrieve(2);
			assertEquals(exUser3, actUser3);
			assertTrue(actUser3.isValidPassword(null));

			User exUser4 = new User(4, "Ronald McDonald", "burgers4life63@outlook.com", null);
			User actUser4 = (User) user.retrieve(3);
			assertEquals(exUser4, actUser4);
			assertTrue(actUser4.isValidPassword(null));

			is.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@AfterEach
	void tearDown() {
		try {
			bs.close();
			os.close();
			user.clear();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
