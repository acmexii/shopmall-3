<template>

    <v-card outlined>
        <v-card-title>
            CreateOrderItem
        </v-card-title>

        <v-card-text>
            <Number label="ProductId" v-model="value.productId" :editMode="editMode"/>
            <Number label="Quantity" v-model="value.quantity" :editMode="editMode"/>
            <StockId offline label="StockId" v-model="value.stockId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createOrderItem"
            >
                CreateOrderItem
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'CreateOrderItemCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.productId = 0;
        this.value.quantity = 0;
        this.value.stockId = {};
    },
    watch: {
    },
    methods: {
        createOrderItem() {
            this.$emit('createOrderItem', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

