<template>
    <v-card outlined style="border-radius: 0; margin-top: 10px; padding-bottom: 10px; background-color: #F4F5FA;">
        <v-card-title>
            주문 요약 목록
        </v-card-title>
    
        <v-card-text style="margin-top:-10px;">
            <v-row no-gutters style="margin: 15px 0px -10px -15px;">
                <v-col style="max-width:140px;">
                    <Number class="attributes-list" label="UserId" v-model="value.parameters.userId" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:150px;">
                    <OrderStatus style="margin-top: 0px; margin-left: 10px;" offline label="OrderStatus" v-model="value.parameters.orderStatus" :editMode="editMode" @change="change"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <Date class="attributes-list" label="FromDate" v-model="value.parameters.fromDate" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <Date class="attributes-list" label="ToDate" v-model="value.parameters.toDate" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <Number class="attributes-list" label="Page" v-model="value.parameters.page" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <Number class="attributes-list" label="PageSize" v-model="value.parameters.pageSize" :editMode="editMode"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn contrast-primary-text"
                        @click="search"
                        small
                        style="margin-left: 35px; margin-top: 30px;"
                        color="primary"
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
    export default {
        name: 'OrderSummary',
        components:{
        },
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'orders/search/orderSummary',
                parameters: {}
            },
        }),
        created() {
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                search = this.value;
                this.$emit('search', search);
            },
            change() {
                this.$emit("update:modelValue", this.value);
            },
        }
    }
</script>
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

