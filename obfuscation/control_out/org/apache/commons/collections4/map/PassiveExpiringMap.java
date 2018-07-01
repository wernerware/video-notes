package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class PassiveExpiringMap extends AbstractMapDecorator implements Serializable {
   private static final long serialVersionUID = 1L;
   private final Map expirationMap;
   private final PassiveExpiringMap.ExpirationPolicy expiringPolicy;

   private static long validateAndConvertToMillis(long timeToLive, TimeUnit timeUnit) {
      if (timeUnit == null) {
         throw new NullPointerException("Time unit must not be null");
      } else {
         return TimeUnit.MILLISECONDS.convert(timeToLive, timeUnit);
      }
   }

   public PassiveExpiringMap() {
      this(-1L);
   }

   public PassiveExpiringMap(PassiveExpiringMap.ExpirationPolicy expiringPolicy) {
      this(expiringPolicy, new HashMap());
   }

   public PassiveExpiringMap(PassiveExpiringMap.ExpirationPolicy expiringPolicy, Map map) {
      super(map);
      this.expirationMap = new HashMap();
      if (expiringPolicy == null) {
         throw new NullPointerException("Policy must not be null.");
      } else {
         this.expiringPolicy = expiringPolicy;
      }
   }

   public PassiveExpiringMap(long timeToLiveMillis) {
      this(new PassiveExpiringMap.ConstantTimeToLiveExpirationPolicy(timeToLiveMillis), new HashMap());
   }

   public PassiveExpiringMap(long timeToLiveMillis, Map map) {
      this(new PassiveExpiringMap.ConstantTimeToLiveExpirationPolicy(timeToLiveMillis), map);
   }

   public PassiveExpiringMap(long timeToLive, TimeUnit timeUnit) {
      this(validateAndConvertToMillis(timeToLive, timeUnit));
   }

   public PassiveExpiringMap(long timeToLive, TimeUnit timeUnit, Map map) {
      this(validateAndConvertToMillis(timeToLive, timeUnit), map);
   }

   public PassiveExpiringMap(Map map) {
      this(-1L, map);
   }

   public void clear() {
      super.clear();
      this.expirationMap.clear();
   }

   public boolean containsKey(Object key) {
      this.removeIfExpired(key, this.now());
      return super.containsKey(key);
   }

   public boolean containsValue(Object value) {
      this.removeAllExpired(this.now());
      return super.containsValue(value);
   }

   public Set entrySet() {
      this.removeAllExpired(this.now());
      return super.entrySet();
   }

   public Object get(Object key) {
      this.removeIfExpired(key, this.now());
      return super.get(key);
   }

   public boolean isEmpty() {
      this.removeAllExpired(this.now());
      return super.isEmpty();
   }

   private boolean isExpired(long now, Long expirationTimeObject) {
      if (expirationTimeObject == null) {
         return false;
      } else {
         long expirationTime = expirationTimeObject;
         return expirationTime >= 0L && now >= expirationTime;
      }
   }

   public Set keySet() {
      this.removeAllExpired(this.now());
      return super.keySet();
   }

   private long now() {
      return System.currentTimeMillis();
   }

   public Object put(Object key, Object value) {
      long expirationTime = this.expiringPolicy.expirationTime(key, value);
      this.expirationMap.put(key, expirationTime);
      return super.put(key, value);
   }

   public void putAll(Map mapToCopy) {
      Iterator i$ = mapToCopy.entrySet().iterator();

      while(i$.hasNext()) {
         Entry entry = (Entry)i$.next();
         this.put(entry.getKey(), entry.getValue());
      }

   }

   public Object remove(Object key) {
      this.expirationMap.remove(key);
      return super.remove(key);
   }

   private void removeAllExpired(long now) {
      Iterator iter = this.expirationMap.entrySet().iterator();

      while(iter.hasNext()) {
         Entry expirationEntry = (Entry)iter.next();
         if (this.isExpired(now, (Long)expirationEntry.getValue())) {
            super.remove(expirationEntry.getKey());
            iter.remove();
         }
      }

   }

   private void removeIfExpired(Object key, long now) {
      Long expirationTimeObject = (Long)this.expirationMap.get(key);
      if (this.isExpired(now, expirationTimeObject)) {
         this.remove(key);
      }

   }

   public int size() {
      this.removeAllExpired(this.now());
      return super.size();
   }

   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      this.map = (Map)in.readObject();
   }

   private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(this.map);
   }

   public Collection values() {
      this.removeAllExpired(this.now());
      return super.values();
   }

   public interface ExpirationPolicy extends Serializable {
      long expirationTime(Object var1, Object var2);
   }

   public static class ConstantTimeToLiveExpirationPolicy implements PassiveExpiringMap.ExpirationPolicy {
      private static final long serialVersionUID = 1L;
      private final long timeToLiveMillis;

      public ConstantTimeToLiveExpirationPolicy() {
         this(-1L);
      }

      public ConstantTimeToLiveExpirationPolicy(long timeToLiveMillis) {
         this.timeToLiveMillis = timeToLiveMillis;
      }

      public ConstantTimeToLiveExpirationPolicy(long timeToLive, TimeUnit timeUnit) {
         this(PassiveExpiringMap.validateAndConvertToMillis(timeToLive, timeUnit));
      }

      public long expirationTime(Object key, Object value) {
         if (this.timeToLiveMillis >= 0L) {
            long now = System.currentTimeMillis();
            return now > Long.MAX_VALUE - this.timeToLiveMillis ? -1L : now + this.timeToLiveMillis;
         } else {
            return -1L;
         }
      }
   }
}
