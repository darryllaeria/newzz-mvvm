package com.example.newzz.base.data.model

// MARK: - Objects
object ReportJsonKey {
    const val reason_description = "reason_description"
    const val reason_type = "reason_type"
    const val target_category = "target_category"
    const val target_id = "target_id"
}

object ReportReasonType {
    const val other = "Other"
    const val otherHarass = "Other harassment"
    const val sexualHarass = "Sexual harassment"
    const val spamOrAd = "Spam/Advertising"
}

object ReportTargetType {
    const val message = "MessageModel"
    const val room = "Room"
    const val user = "UserModel"
}

// MARK: - Data Class
data class ReportData(
    var reasonContent: String = "",
    var reasonType: String = ReportReasonType.other,
    var targetId: String = "",
    var targetType: String = ReportTargetType.user
)

