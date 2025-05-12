package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class OrderItemHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<OrderItem>> {

    @Override
    public EntityModel<OrderItem> process(EntityModel<OrderItem> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "createorderitem")
                .withRel("reateorderitem")
        );

        return model;
    }
}
