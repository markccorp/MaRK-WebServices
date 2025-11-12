package in.co.mark.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A utility class that provides efficient, thread-safe mapping from integer
 * values to {@code enum} constants.
 * <p>
 * This cache supports {@code enum} that implement {@link IntValuedEnum}
 * interface, which exposes a unique integer value for each {@code enum}
 * constant. The mapping is built once per {@code enum} type and reused for fast
 * lookups.
 * </p>
 *
 * <p>
 * Example usage: <br/>
 * {@code OrgUserRole role = EnumValueCache.fromValue(OrgUserRole.class, 20);}
 * </P>
 * 
 * @author Rakesh Kumar
 */
public class IntValuedEnumCache {
	/**
	 * Internal cache storing value-to-enum mappings for each {@code enum} type. The
	 * outer map keys are {@code enum} classes; the inner maps associate integer
	 * values with {@code enum} constants.
	 */
	private static final Map<Class<?>, Map<Integer, ?>> ENUM_CACHE = new ConcurrentHashMap<>();

	/**
	 * Retrieves the {@code enum} constant corresponding to the given integer value
	 * for the specified {@code enum} class.
	 * <p>
	 * The {@code enum} class must implement {@link IntValuedEnum} and expose a
	 * public {@code getValue()} method. The mapping is cached after the first
	 * lookup to ensure fast and thread-safe access.
	 * </p>
	 *
	 * @param enumClass the class of the {@code enum} implementing
	 *                  {@code IntValuedEnum}
	 * @param value     the integer value to resolve
	 * @param <E>       the type of the {@code enum}
	 * @return the {@code enum} constant associated with the given value
	 * @throws IllegalArgumentException if the value does not correspond to any
	 *                                  {@code enum} constant
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Enum<E> & IntValuedEnum> E fromValue(Class<E> enumClass, int value) {
		Map<Integer, E> valueMap = (Map<Integer, E>) ENUM_CACHE.computeIfAbsent(enumClass, cls -> {
			Map<Integer, E> map = new ConcurrentHashMap<>();
			E[] constants = (E[]) cls.getEnumConstants();
			for (E constant : constants) {
				map.put(constant.getValue(), constant);
			}

			return map;
		});

		E result = valueMap.get(value);
		if (result == null) {
			throw new IllegalArgumentException("Unknown value: " + value + " for enum " + enumClass.getSimpleName());
		}

		return result;
	}
}
