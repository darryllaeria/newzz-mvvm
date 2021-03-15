package com.example.newzz.base.data.database

//import com.example.newzz.base.BuildConfig
//import com.example.newzz.base.Constants
//import com.example.newzz.base.data.encryption.CipherWrapper
//import com.example.newzz.base.data.encryption.KeyStoreWrapper
//import com.example.newzz.base.manager.PrefsManager
//import io.realm.Realm
//import io.realm.RealmConfiguration
//import java.security.SecureRandom
//
//object RealmDB {
//
//    // MARK: - Private Constant
//    private const val DB_KEY = "realm_key"
//
//    // MARK: - Public Functions
//    fun clearDB() {
//        Realm.getDefaultInstance().use { realm ->
//            realm.executeTransaction {
//                it.deleteAll()
//            }
//        }
//    }
//
//    fun getConfig(prefMan: PrefsManager, keyStore: KeyStoreWrapper): RealmConfiguration {
//        val cipher = CipherWrapper(CipherWrapper.TRANSFORMATION_ASYMMETRIC)
//        var password = prefMan.getString(Constants.KEY_SECRET_DB, "")
//        val keys = keyStore.getAsymmetricKeyPair(DB_KEY)
//        if (password.isEmpty()) {
//            val bytes = ByteArray(64)
//            SecureRandom().nextBytes(bytes)
//            password = String(bytes, Charsets.ISO_8859_1)
//            prefMan.putString(Constants.KEY_SECRET_DB, cipher.encrypt(password, keys.public))
//        } else {
//            password = cipher.decrypt(password, keys.private)
//        }
//
//        // Check current schema version with latest and update
//        val buildSchemaVersion = BuildConfig.VERSION_REALM_SCHEMA.toLong()
//        val sharedPrefSchemaVersion = prefMan.getLong(Constants.KEY_VERSION_REALM_SCHEMA, 0L)
//        val realmConfig = RealmConfiguration.Builder()
//            .encryptionKey(password.toByteArray(Charsets.ISO_8859_1))
//            .deleteRealmIfMigrationNeeded()
//            .name(Constants.DB_NAME)
//            .schemaVersion(buildSchemaVersion)
//        return if (buildSchemaVersion > sharedPrefSchemaVersion) {
//            prefMan.putLong(Constants.KEY_VERSION_REALM_SCHEMA, buildSchemaVersion)
//            realmConfig.schemaVersion(buildSchemaVersion).build()
//        } else {
//            realmConfig.schemaVersion(sharedPrefSchemaVersion).build()
//        }
//
//    }
//}