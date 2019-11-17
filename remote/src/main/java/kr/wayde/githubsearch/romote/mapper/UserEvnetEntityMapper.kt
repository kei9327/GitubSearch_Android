package kr.wayde.githubsearch.romote.mapper

import kr.wayde.githubsearch.domain.entity.*
import kr.wayde.githubsearch.romote.model.UserEventModel

class UserEvnetEntityMapper : EntityMapper<UserEventModel, UserEvent> {
    override fun mapFromRemote(model: UserEventModel): UserEvent =
        UserEvent(model.id,
            model.type,
            Actor(model.actor.id,
                model.actor.login,
                model.actor.display_login,
                model.actor.gravatar_id,
                model.actor.url,
                model.actor.avatar_url),
            model.public,
            model.created_at
        )

}
